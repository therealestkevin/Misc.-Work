import java.util.Arrays;

public class longestSubArray{

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSubArray(new int[] {-3,5,7,8,9,10,13,15,66,-1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8,9,10,11})));
    }
    public static int[] findSubArray(int[]nums){
        int res = 0, cnt = 0;
        int start =0;
        int end =0;
        int curStart=0;
        boolean chain =false;
        for(int i = 0; i < nums.length; i++){
            if((i == 0 || nums[i-1] < nums[i])&&chain) {
                 cnt++;
                 if(cnt>res){
                     res = cnt;
                    end =i;
                    start = curStart;
                 }
            }else if(i == 0 || nums[i-1] < nums[i]){
                chain=true;
                curStart=i-1;
               
            }else{
                chain=false;
            
                if(cnt>res){
                    res = cnt;
                    end=i-1;
                    start=curStart;
                }
                cnt=1;
            }
           
            
        }
        if(start<0){
            start=0;
        }
        return Arrays.copyOfRange(nums, start, end+1);
    }





















    
    public static int[] returnLongestSub(int[] nums){
        int[] isSorted = new int[nums.length];
        int maxLong =-1;
        int startIndex=0;
        int endIndex=0;
        boolean isChain=false;
        int curCounter=0;

        int curStart=0;
        int curEnd =0;
        for(int i =0; i<nums.length-1;i++){
            if(i==nums.length-2){
                if(nums[i]<nums[i+1]){
                    isSorted[i]=1;
                    isSorted[i+1]=1;
                    curCounter+=2;
                    curEnd=i+1;
                    if(curCounter>maxLong){
                        startIndex=curStart;
                        endIndex = curEnd;
                    }
                }else{
                    curEnd =i;
                    curCounter++;
                    if(curCounter>maxLong){
                        startIndex=curStart;
                        endIndex = curEnd;
                    }
                }
            }else{
                if(nums[i]<nums[i+1] && isChain){
                    isSorted[i]=1;
                    curCounter++;
                }else if(nums[i]<nums[i+1]){
                    isSorted[i]=1;
                    curCounter++;
                    isChain=true;
                    curStart=i;
                }else if(nums[i]>nums[i+1]){
                    isSorted[i]=0;
                    isChain=false;
                    curEnd=i;
                    if(curCounter>maxLong){
                        startIndex=curStart;
                        endIndex = curEnd;
                    }
                    curStart=i+1;
                    curCounter=0;
                }

            }
        }
        return Arrays.copyOfRange(nums, startIndex, endIndex+1);
    }
    public static int[] returnLongestSub2(int[] nums){
        int[] isSorted = new int[nums.length];
        int maxLong =-1;
        int startIndex=0;
        int endIndex=0;
        boolean isChain=false;
        int curCounter=0;

        int curStart=0;
        int curEnd =0;
        for(int i =0; i<nums.length-1;i++){
            if(i==nums.length-2){
                if(nums[i]<nums[i+1]){
                    isSorted[i]=1;
                    isSorted[i+1]=1;
                }else{
                    isSorted[i]=1;
                }
            }else{
                if(nums[i]<nums[i+1]){
                    isSorted[i]=1;
            }
        }
    }
        for(int i =0; i<isSorted.length-1;i++){
            if(i==isSorted.length-2){
                if(isSorted[i+1]==1){
                    curCounter+=2;
                    if(curCounter>maxLong){
                        startIndex=curStart;
                        endIndex = curEnd;
                    }
                }else{
                    curCounter++;
                    if(curCounter>maxLong){
                        startIndex=curStart;
                        endIndex =curEnd;
                    }
                }
            }else if(isSorted[i]==1 && isChain){
                if(i==isSorted.length-2){
                    if(isSorted[i+1]==1){
                        curCounter+=2;
                        if(curCounter>maxLong){
                            startIndex=curStart;
                            endIndex = curEnd;
                        }
                    }else{
                        curCounter++;
                        if(curCounter>maxLong){
                            startIndex=curStart;
                            endIndex =curEnd;
                        }
                    }
                }else{
                    curCounter++;
                }
            }else if(isSorted[i]==1 ){
                curStart =i;
                curCounter++;
                isChain=true;
            }else{
                curEnd=i;
                curCounter++;
                isChain=false;
                if(curCounter>maxLong){
                    startIndex=curStart;
                    endIndex = curEnd;
                }
                curCounter=0;
            }
        }

        return Arrays.copyOfRange(nums, startIndex, endIndex+1);
    }
   
    public static int findLengthOfLCIS(int []nums){
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return 1;
        }
        int[] isSorted = new int[nums.length];
        int maxLong =1;
        int curCounter=0;
        for(int i =0; i<nums.length-1;i++){
            if(i==nums.length-2){
                if(nums[i]<nums[i+1]){
                    isSorted[i]=1;
                    isSorted[i+1]=1;
                    curCounter+=2;
                   
                    maxLong = Math.max(maxLong, curCounter);
                }else{
                    maxLong = Math.max(maxLong,curCounter+1);
                }
            }else{
                if(nums[i]<nums[i+1] ){
                    isSorted[i]=1;
                    curCounter++;
                }else if(nums[i]>nums[i+1]){
                    isSorted[i]=0;
                   curCounter++;
                    maxLong = Math.max(maxLong, curCounter);  
                    curCounter=0;
                }

            }

    }
    return maxLong;
}
}
