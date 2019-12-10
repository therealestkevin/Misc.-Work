import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class memoryMapped {

    public static void main(String[] args) {
        try (RandomAccessFile numbers = new RandomAccessFile(new File("random1.txt"), "r"))
        {
            FileChannel fc = numbers.getChannel();
            MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

            int[] nums = new int[100001];
            while(buffer.hasRemaining()){
                if((char) buffer.get()==13 || (char)buffer.get() == 10){

                }
            }
            for (int i = 0; i < buffer.limit(); i++)
            {
                nums[(char)buffer.get()]++;
            }
            int curInd = 0;
            int[] printArr = new int[buffer.limit()];
            for(int i = 0; i < nums.length; i++){
                while(nums[i] > 0){
                    nums[i]--;
                    printArr[curInd] = i;
                    curInd++;
                }
            }
            for(int i : nums){
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
