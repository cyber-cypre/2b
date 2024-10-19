package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns=new AList<>(){};
        AList<Double> times=new AList<>(){};
        int[] ns={1000,2000,4000,8000,16000,32000,64000,128000};
        int j=0;
        while (j<=ns.length-1){
            AList<Integer> aList=new AList<>(){};
            Stopwatch sw=new Stopwatch();
            for(int i =0;i<ns[j];i++){
                aList.addLast(i);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            j++;
        }
        for (int number: ns) {
            Ns.addLast(number);
        }
        printTimingTable(Ns,times,Ns);
    }
}
