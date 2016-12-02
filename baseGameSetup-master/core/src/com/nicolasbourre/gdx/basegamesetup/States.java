package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by 1285798 on 16-11-21.
 */
public interface States {
        void doAction(Context ctx, Homer homer);


}
class Running implements States
{
    public Running()
    {
    }
    public void doAction(Context ctx,Homer homer)
    {
    }

}
class Walking implements States
{
    public Walking()
    {
    }
    public void doAction(Context ctx,Homer homer)
    {

    }

}
class Jumping implements States
{
    public Jumping()
    {
    }
    public void doAction(Context ctx,Homer homer)
    {
    }

}