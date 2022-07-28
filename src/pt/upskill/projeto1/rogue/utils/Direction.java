package pt.upskill.projeto1.rogue.utils;

/**
 * @author POO2016
 *
 * Cardinal directions
 *
 */
public enum Direction {
	LEFT, UP, RIGHT, DOWN, LEFTUP, LEFTDOWN, RIGHTUP, RIGHTDOWN;

	public Vector2D asVector() {
		if(this==Direction.UP)
		{
		return new Vector2D(0,-1);
		}
		if(this==Direction.DOWN)
		{
			return new Vector2D(0,1);
		}
		if(this==Direction.LEFT)
		{
			return new Vector2D(-1,0);
		}
		if(this==Direction.RIGHT)
		{
			return new Vector2D(1,0);
		}
		if(this==Direction.LEFTUP)
		{
			return  new Vector2D(-1,-1);
		}
		if(this==Direction.LEFTDOWN)
		{
			return  new Vector2D(-1,1);
		}
		if(this==Direction.RIGHTUP)
		{
			return  new Vector2D(1,-1);
		}
		if(this==Direction.RIGHTDOWN)
		{
			return  new Vector2D(1,1);
		}
		return null;
	}
}
