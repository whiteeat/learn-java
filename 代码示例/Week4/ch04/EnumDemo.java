enum Direction  
{  
     EAST, SOUTH, WEST, NORTH
} 
class EnumDemo
{
    public static void main(String[] args)   
    {  
		Direction dir = Direction.NORTH;
        switch(dir)  
        {  
            case EAST:  
                System.out.println("��");  
                break;  
            case SOUTH:  
                System.out.println("����");  
                break;  
            case WEST:  
                System.out.println("����");  
                break;  
            case NORTH:  
                System.out.println("��");  
                break;  
        }  
    }  
}