public class RunPlayfield {
    public static void main(String[] args) {


    
    Snake snake = new Snake ("Snake", 6, 6);
    Rabbit rabbit = new Rabbit ("Rabbit", 2, 2);


    snake.tellPosition();
    rabbit.tellPosition();

    int yRPosition = rabbit.moveUp();
    rabbit.tellPosition();
    int ySPosition = snake.moveDown();
    snake.tellPosition();
    int xRPosition = rabbit.moveRight();
    rabbit.tellPosition();
    int xSPosition = snake.moveLeft();
    snake.tellPosition();

    if(xSPosition ==  xRPosition && ySPosition == yRPosition ){
        System.out.println("Snake: Haps du er spist rabbit");
    }
    else if(xSPosition ==  xRPosition || ySPosition == yRPosition ){
        System.out.println("almost but no cigar");   
    }
    else{
        System.out.println("WAY OFF MAN");
    }
    
    yRPosition = rabbit.moveUp();
    rabbit.tellPosition();

    ySPosition = snake.moveDown();
    snake.tellPosition();
    
    if(xSPosition ==  xRPosition && ySPosition == yRPosition ){
        System.out.println("Snake: Haps du er spist rabbit");
    }
    else if(xSPosition ==  xRPosition || ySPosition == yRPosition ){
        System.out.println("almost but no cigar");   
    }
    else{
        System.out.println("WAY OFF MAN");
    }
    

    xRPosition = rabbit.moveRight();
    rabbit.tellPosition();

    xSPosition = snake.moveLeft();
    snake.tellPosition();


    if(xSPosition ==  xRPosition && ySPosition == yRPosition ){
        System.out.println("Snake: Haps du er spist rabbit");
    }
    else if(xSPosition ==  xRPosition || ySPosition == yRPosition ){
        System.out.println("almost but no cigar");   
    }
    else{
        System.out.println("WAY OFF MAN");
    }

    
    } 


}