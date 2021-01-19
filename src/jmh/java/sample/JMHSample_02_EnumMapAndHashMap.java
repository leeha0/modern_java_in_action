package sample;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class JMHSample_02_EnumMapAndHashMap {

    private Map<State, String> enumMap;
    private Map<State, String> hashMap;

    @Setup
    public void setUp() {
        enumMap = new EnumMap<>(State.class);
        hashMap = new HashMap<>();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void enumMap(Blackhole blackhole) {
        blackhole.consume(enumMap.put(State.SOLID, State.SOLID.name()));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void hashMap(Blackhole blackhole) {
        blackhole.consume(hashMap.put(State.SOLID, State.SOLID.name()));
    }

    enum State {
        SOLID, LIQUID, GAS;
    }
}
