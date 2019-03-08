package com.github.prominence.benchmark;

import com.github.prominence.sort.BubbleSort;
import com.github.prominence.sort.InsertionSort;
import com.github.prominence.sort.MergeSort;
import com.github.prominence.sort.SelectionSort;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingBenchmark {

    @State(Scope.Benchmark)
    public static class MyState {
        private int[] basicData;

        {
            String launchProperty = System.getProperty("array.size");
            int arraySize = launchProperty != null ? Integer.valueOf(launchProperty) : 100000;

            basicData = IntStream.generate(() -> (int) (Math.random() * 10000)).limit(arraySize).toArray();
        }

        int[] getData() {
            return Arrays.copyOf(basicData, basicData.length);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void javaDefaultSort(MyState myState) {
        Arrays.sort(myState.getData());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void bubbleSort(MyState state) {
        BubbleSort.sort(state.getData());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSort(MyState state) {
        SelectionSort.sort(state.getData());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void insertionSort(MyState state) {
        InsertionSort.sort(state.getData());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void mergeSort(MyState state) {
        MergeSort.sort(state.getData());
    }
}
