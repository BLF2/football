package net.blf2.football.model.entity.enumfile;

/**
 * Created by blf2 on 16-4-10.
 */
public enum Position {
    goalkeeper,guard,forward;
    public Boolean isGoalkeeper(){
        if(this == goalkeeper)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    public Boolean isGuard(){
        if(this == guard)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    public Boolean isForward(){
        if(this == forward)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
