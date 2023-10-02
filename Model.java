// Jordan Lyle, 9/24/2022, Model.java for Assignment 3
import java.util.ArrayList;

class Model
{
    ArrayList<Pipe> pipes;
	int dest_x;
	int dest_y;

	Model()
	{
        pipes = new ArrayList<Pipe>();
	}

	public void update()
	{
	}

	public void setDestination(int x, int y)
	{
		this.dest_x = x;
		this.dest_y = y;
	}

	Json marshal()
	{
		Json ob = Json.newObject(); 
		Json tmpList = Json.newList();    
        ob.add("pipes", tmpList);
        for(int i = 0; i < pipes.size(); i++)
		{
            tmpList.add(pipes.get(i).marshal());
		}
		tmpList.save("map.json");
        return ob;
	}

	Model(Json ob)
	{
		pipes = new ArrayList<Pipe>();
		Json tmpList = ob.load("map.json");
		for (int i = 0; i < tmpList.size(); i++)
		{
			pipes.add(new Pipe(tmpList.get(i)));
		}
	}
}