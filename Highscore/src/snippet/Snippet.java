package snippet;

public class Snippet {
	public static void main(String[] args) {
		
		{
			this.Scores.sort(new Comparator<Punktzahl>()
			{
				@Override
				public int compare(Punktzahl o1, Punktzahl o2) {
					if (o1.Punktzahl>o2.Punktzahl) return -1;
					else if (o1.Punktzahl<o2.Punktzahl) return 1;
					return 0;.
				}
		
			});
		}}
	}
}

