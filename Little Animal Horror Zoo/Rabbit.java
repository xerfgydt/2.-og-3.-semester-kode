public class Rabbit {

    private String name;
    private int xRPosition;
    private int yRPosition;

    public Rabbit(String name, int xRPosition, int yRPosition) {
        this.name = name;
        this.xRPosition = xRPosition;
        this.yRPosition = yRPosition;
    }
    
    public void setNameRabbit(String name) {
        System.out.println("Rabbit");
    }
    public int moveUp(){
        this.yRPosition = yRPosition + 1 ;
        return this.yRPosition;

    }
    public int moveDown(){
        this.yRPosition = yRPosition - 1 ;
        return this.yRPosition;

    }
    public int moveRight(){
        this.xRPosition = xRPosition + 1 ;
        return this.xRPosition;

    }
    public int moveLeft(){
        this.xRPosition = xRPosition - 1 ;
        return this.xRPosition;

    }
    
    public void tellPosition(){
        System.out.println("Jeg er Rabbit. Jeg er nu her: " + xRPosition +"," + yRPosition);
    }
    
    //public void mercy(String) {
        //System.out.println("ask for mercy")
    //}
}




