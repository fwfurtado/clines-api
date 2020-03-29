PROJECT_NAME = 'caelum/clines'
JAR ?= ./target/clines-api-0.0.1-SNAPSHOT.jar

.PHONY: package test lint run stop psql

package:
	@ ./mvnw clean package -DskipTests

test:
	@ ./mvnw test

lint:
	@ ./mvnw validate

run: _docker-build-image
	@ docker-compose up -d

stop:
	@ docker-compose down -v

psql:
	@ docker-compose exec database psql -U postgres


deploy/production:
	@ make _deploy APP=clines-api

deploy/staging:
	@ make _deploy APP=clines-api-staging

_deploy: _docker-build-image _login-with-docker-registry
	@ make _publish-docker-image APP=$(APP) VERSION=$$TRAVIS_BUILD_ID
	@ make _publish-docker-image APP=$(APP) VERSION=latest
	make _release IMAGE_ID=$$(docker image inspect registry.heroku.com/$(APP)/web:latest -f {{.Id}} )

_docker-build-image: package $(JAR)
	$(info building docker image...)
	@ docker image build --build-arg JAR=$(JAR) -t $(PROJECT_NAME):latest .

_login-with-docker-registry:
	@ docker login --username=_ --password=$$DOCKER_REGISTRY_PASS registry.heroku.com
	$(info logged in registry.heroku.com)

_publish-docker-image:
	@ make _docker-re-tag-image from=$(PROJECT_NAME):latest to=registry.heroku.com/$(APP)/web:$(VERSION)

	$(info publishing image registry.heroku.com/$(APP)/web:$(VERSION))
	@ docker image push registry.heroku.com/$(APP)/web:$(VERSION)

_docker-re-tag-image:
	$(info re-tag image from $(from) to $(to))
	@ docker image tag $(from) $(to)

	$(info there is the id of image $(to))
	@ docker image inspect $(to) -f {{.Id}}

_release:
	$(info Create relaese to image id $(IMAGE_ID))
	@ curl -X PATCH \
			-H "Authorization: Bearer $$DOCKER_REGISTRY_PASS" \
			-H "Content-Type: application/json" \
			-H "Accept:application/vnd.heroku+json; version=3.docker-releases" \
			-d '{ "updates": [{"type": "web",  "docker_image": "$(IMAGE_ID)"}] }' \
			https://api.heroku.com/apps/clines-api-staging/formation
