APP_NAME = 'caelum/clines'
VERSION ?= '0.0.0-SNAPSHOT'
IMAGE_TAG = $(APP_NAME):$(VERSION)

_required/jar:
ifndef jar
	$(error "The 'jar' argument is required")
endif

docker/run: docker/build
	@ docker-compose up -d

docker/stop:
	@ docker-compose down -v

docker/psql:
	@ docker-compose exec database psql -U postgres

docker/build: _required/jar maven/package $(jar)
	$(info building docker image...)
	@ docker image build --build-arg JAR=$(jar) -t $(IMAGE_TAG) .
	@ make docker/re-tag from=$(IMAGE_TAG) to=$(APP_NAME):latest

docker/re-tag:
	$(info re-tag image from $(from) to $(to))
	@ docker image tag $(from) $(to)


maven/package:
	@ ./mvnw clean package -DskipTests