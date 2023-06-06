public class ErrorScenario {
    static void remove(int toRemove, int[] arr){
        if(arr == null){
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == toRemove){
                arr[i] = 0;
            }
        }
    }
}
