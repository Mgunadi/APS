package revision;
import java.util.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class Polymorphism {
	private List <Butler> House = new ArrayList<Butler>();
	Butler[] Household = new Butler[4];
	Butler s1 = new Scott(30, "nike", new Job("Pageup", 70000.0), new Disposition("Happy"));
	
	SortedSet<String> friends = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	SortedSet<String> cfriends = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	LinkedList<Integer> mishaps  = new LinkedList<Integer>();
	
	Map<String, Integer> friendlist = new HashMap<>();
		
	public void initialize() {
		String grumps = "grumpy"; 
		final Disposition stubborn = new Disposition(grumps);
		Butler c1 = new Craig(32, "Suit", new Job("contractor", 50000.0), stubborn);
		Butler s2 = new EvilScott();
		Butler c2 = new Craig(new Job("IBM", 40000.0));
		//Butler s3 = new Butler();
		Household[0] = s1;
		Household[1] = c1;
		Household[2] = s2;
		Household[3] = c2;
		//Household[4] = s3;
		Collections.addAll(House, Household);
	}

	public void main() {
		initialize();
		
		for (Butler person : House) {
			if (person instanceof Scott) {
				((Scott)person).getName();
			} else if (person instanceof Craig){
				((Craig)person).getName();
			}
		}
		
		System.out.println("Who is who?");
		for (Butler person : House) {
			System.out.println("*");
			if (!(person instanceof Scott)) {
				String name = ((Craig)person).getName();
				System.out.printf("%s is such a whinger \n",name);
				if (((Craig)person).getJob() == null)
					System.out.println("He cries because he has no job.");
			} else {
				((Scott)person).playsMonopoly();
				System.out.println("Do they play monopoly? " + ((Scott)person).hasGame());
				System.out.println(person.getCompany());
			}
		}
	}
	
	public void pracCollections() {
		friends.add("Jonathon");
		friends.add("Matthew");
		friends.add("Adam");
		friends.add("Nihit");
		//friends.add(null);    ---> cannot put a null object in Treeset
		System.out.println(friends);
		
		cfriends.add("Mick");
		cfriends.add("Ash");
		cfriends.add("Adam");
		cfriends.add("Nihit");
		System.out.println(cfriends);
		
		
		System.out.println();
		friendlist.put("Jonathon", 6);
		friendlist.put("Matthew", 4);
		friendlist.put("Adam", 1);
		System.out.println(friendlist);
		System.out.println(friendlist.size());
	}
	
	public void Collections() {
		friends.retainAll(cfriends);
		System.out.printf("Scott and Craig's friends include: %s", friends );
		
		List<String> CraigsList = new ArrayList<String>() {
			{ add("Ben");
				add("Nick");
				add("Ben");
				add("Stephen");
				add("Nihit");
				add("Simon");}                            };
		System.out.println();
		System.out.println("The following is Craig's List:");
		System.out.println(CraigsList);
		
		//shuffling:
		Collections.shuffle(CraigsList);
		System.out.println(CraigsList);
		Collection noDups = new HashSet(CraigsList);
		System.out.println(noDups);
	}
	
	public void LinkedList() {
		mishaps.add(2000);
		mishaps.add(2003);
		mishaps.add(2005);
		mishaps.add(2008);
		
		System.out.println(mishaps);
		
		mishaps.set(2, 2004);
		System.out.println(mishaps);
	}
	
	public <T extends Butler> void markFace(T butler) {
		if (butler instanceof Craig) {
			butler.face = "clean";
		} else {
			butler.face = "pock-marked";
		}
	}

	public void part2() {
		System.out.println(s1.singleparent);
		System.out.println("What happened to them?");
		Butler.LifeHappens(); //can also do person.LifeHappens();
		System.out.println(Butler.singleparent);
		
		Craig annoyingOne = ((Craig)House.get(1));
		annoyingOne.waitformiracle();
		System.out.println("Meanwhile, Craig 1 wil wait for: " + annoyingOne.singleparent);
		System.out.printf("He will forever be a %s guy", annoyingOne.getDisp());
		System.out.print("\nMay never ");
		annoyingOne.getMarried();;
		
		System.out.println();
		for (Butler person : House) {
			person.getMarried();
			try {
				System.out.println(((Scott)person).attack());
			} catch (ClassCastException c) {
				System.out.println("Craig doesn't know how to attack at all.");
			} catch (Exception e) {
				System.out.println("Generic error");
			} finally {
				System.out.println("Finally.");
			}
		}	
	}
	
	public void part3() {
		SecondLast phones = new SecondLast(new String[] {"iphone1", "iphone 6", "Woolies2", "woolies3"});
		phones.getSecondLast();
		SecondLastPair phonespair = new SecondLastPair(new String[] {"iphone1", "iphone 6", "Woolies2", "woolies3"}, new String[] {"samsung1", "samsung2", "oppo2", "woolies3"});
		phonespair.getSecondLast();
	}
}	

abstract class Butler {
	public static boolean singleparent = false;
	private int age;
	private String clothes;
	private Job position;
	private Disposition personality;
	String face;
	
	public Butler(int age, String clothes, Job title, Disposition disp) {
		this.age = age;
		this.clothes = clothes;
		position = title;
		personality = disp;
	}
	
	public String getName() {
		return "Butler";
	}
	
	public Job getJob() {
		return position;
	}
	
	public String getDisp() {
		return personality.getDesc();
	}
	
	public String getCompany() {
		return position.getCompany();
	}
	
	public static void LifeHappens() {
		singleparent = !singleparent;
	}

	abstract void getMarried();
}

class Scott extends Butler implements ArgumentStyle{
	
	private boolean hasGame;
	
	public Scott(int age, String clothes, Job title, Disposition d) {
		super(age, clothes, title, d);
	}
	
	public Scott() {
		this(30, "Hurley tshirt", new Job("Kartaway Bins", 25000.0), null);
	}
	
	@Override
	public String getName() {
		return super.getName().concat("Scott");
	}
	
	public void playsMonopoly(){
		hasGame = true;
	}
	
	public boolean hasGame() {
		return hasGame;
	}

	@Override
	void getMarried() {
		System.out.println("Married to a guy");
		
	}

	@Override
	public String attack() {
		return "Passive-aggressive";
	}
}

class EvilScott extends Scott {
	@Override
	public String attack() {
		return "Catty";
	}
	
	
}

class Craig extends Butler {
	
	public Craig(int age, String clothes, Job title, Disposition d) {
		super(age, clothes, title, d);
	}
	
	public Craig(Job title) {
		this(27, "pyjamas", new Job("Kartaway Bins", 25000.0), null);
	}
	
	public Craig() {
		this((int) 29.3, "Business shirt", null, null);
	}
	@Override
	public String getName() {
		return "Craig";
	}
	
	public void waitformiracle() {
		LifeHappens();
	}

	@Override
	void getMarried() {
		System.out.println("Married to a girl");
		
	}
}

class Job{
	
	private String company;
	private double wage;
	
	public Job(String company, double wage) {
		this.company = company;
		this.wage = wage;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public double wage() {
		return this.wage();
	}
	
}

class Disposition{
	private String disposition;
	
	public Disposition(String personality) {
		disposition = personality;
	}
	
	public String getDesc() {
		return disposition;
	}
}

interface ArgumentStyle{
	public int AggressionLevel = 8;
	String attack();
	
}	

class SecondLast<T>{
	private T[] Array;
	SecondLast(T[] o){
		Array = o;
	}
	
	public void getSecondLast() {
		System.out.println(Array[Array.length - 2]);
	}
}	

class SecondLastPair<U, V>{
	private U[] Scotts;
	private V[] Craigs;
	
	SecondLastPair(U[] u, V[] v){
		Scotts = u;
		Craigs = v;
	}
	
	public void getSecondLast(){
		System.out.println(Scotts[Scotts.length -2]);
		System.out.println(Craigs[Craigs.length -2]); 
	}
}