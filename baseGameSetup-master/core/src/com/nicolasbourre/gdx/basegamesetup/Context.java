package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by 1285798 on 16-11-21.
 */
class Context
{
        States state;
        public Context(States st)
        {
            state = st;
        }
        public States getState()
        {
            return this.state;
        }
        public void setState(States st)
        {
            this.state = st;
        }
    }

