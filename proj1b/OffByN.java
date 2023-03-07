public class OffByN  implements CharacterComparator{

    private int N;

    public OffByN(int N){
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff =  x - y;
        diff = Math.abs(diff);
        if(diff == this.N){
            return true;
        }
        return  false;
    }
}
