package me.github.fwfurtado.clines.infra;

public interface Mapper<S, T> {
    T map(S source);
}
