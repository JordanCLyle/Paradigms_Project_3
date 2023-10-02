// Jordan Lyle, 9/24/2022, Pipe.java for Assignment 3

class Pipe
{
	int x;
	int y;

	Pipe(int horizontal,int vertical)
	{
		x = horizontal;
		y = vertical;
	}

	public int onUserClickLocation(int clickX, int clickY)
	{
		{
			if ((x <= clickX) && (x >= clickX - 50) && (y <= clickY) && (y >= clickY - 400))
			{
				return 10;
			}
			else if (((x <= clickX + 50) && (x >= clickX - 50)))
			{
				return 5;
			}
			else
			{
				return 2;
			}
		}
	}

	Json marshal()
	{
		Json ob = Json.newObject();
		ob.add("x", x);
		ob.add("y", y);
        return ob;
	}

	Pipe(Json ob)
	{
		x = (int)ob.getLong("x");
		y = (int)ob.getLong("y");
	}

}