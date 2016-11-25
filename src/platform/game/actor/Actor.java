package platform.game.actor;

import platform.game.Damage;
import platform.game.World;
import platform.util.*;

/**
 * Base class of all simulated actors, attached to a world.
 */
public abstract class Actor implements Comparable<Actor>
{
    protected int priority = -1;
    protected Sprite sprite = null;
    
    private World world = null;
    
    @Override
    public int compareTo(Actor other)
    {
        if(priority == other.getPriority())
            return 0;
        
        return priority > other.getPriority() ? -1 : 1;
    }
    
    public void register(World world)
    {
        this.world = world;
    }
    
    public void unregister()
    {
        world = null;
    }
    
    protected World getWorld()
    {
        return world;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void interact(Actor other)
    {
    }
    
    public boolean isSolid()
    {
        return false;
    }
    
    public Box getBox()
    {
        return null;
    }
    
    public Vector getPosition()
    {
        Box box = getBox();
        if(box == null)
            return null;
        return box.getCenter();
    }
    
    public void preUpdate()
    {
    }
    
    public void postUpdate()
    {
    }
    
    public void update(Input input)
    {
    }
    
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        return false;
    }
    
    public Sprite getSprite(String name)
    {
        if(world == null)
            return null;
        
        return world.getLoader().getSprite(name);
    }
    
    public void draw(Input input, Output output)
    {
        if(sprite != null)
            output.drawSprite(sprite, getBox());
    }
}