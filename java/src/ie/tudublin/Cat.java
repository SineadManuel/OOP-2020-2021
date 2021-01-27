package ie.tudublin;

public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
        setNumLives(9); 
    }

    private int numLives;

    // Accessor method for reading the private field
    public int getNumLives() {
        return numLives;
    }

    // Accessor method for writing to the private field
    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public void kill()
    {
        numLives = numLives - 1;

        if(numLives > 0)
        {
            System.out.println("Ouch!");
        }
        else if (numLives == 0)
        {
            System.out.println("Dead");
        }
    }
}