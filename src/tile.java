public class tile {
    private boolean isMine = false;
    private int surround;
    private boolean isFlagged = false;
    private boolean isRevealed = false;

    public tile(boolean mine, int surrounding) {
        isMine = mine;
        surround = surrounding;
    }
    public void setSurrounding(int amount) {
        //90% sure not needed as you can't change the mines around a spot
    }
    public void setFlagged(boolean flag) {
        isFlagged = flag;
    }
    public void setReveal(boolean reveal){
        isRevealed = reveal;
    }
    public boolean getMineStatus() {
        return isMine;
    }
    public boolean getRevealed(){
        return isRevealed;
    }
    public boolean getFlaggedStatus() {
        return isFlagged;
    }
    public int getSurroundingAmount() {
        return surround;
    }
    public String toString() {
        //NEEDS TO BE FIXED
        return ""+surround;
    }
}
