package platform.game.level;

import platform.game.actor.Actor;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;

/**
 * Base class for level factories, which provides fade in transition. Subclasses
 * are requires to override <code>register</code>.
 */
public abstract class Level extends Actor
{
    private double fadein;
    
    public Level()
    {
        fadein = 1.0;
    }
    
    /**
     * @return a new instance of default level
     */
    public static Level createDefaultLevel()
    {
        return new BasicLevel();
    }
    
    @Override
    public int getPriority()
    {
        return Integer.MAX_VALUE;
    }
    
    @Override
    public void update(Input input)
    {
        fadein -= input.getDeltaTime();
        if(fadein <= 0.0)
            getWorld().unregister(this);
    }
    
    @Override
    public void draw(Input input, Output output)
    {
        Sprite sprite = getSprite("pixel.black");
        if(getWorld() == null)
            throw new NullPointerException();
        output.drawSprite(sprite, output.getBox(), 0.0, fadein);
    }
}
