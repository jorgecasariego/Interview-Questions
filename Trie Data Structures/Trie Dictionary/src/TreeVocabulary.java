import java.util.Collection;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The elements are ordered using their {@linkplain Comparable natural
 * ordering}
 * 
 * This implementation provides guaranteed log(n) time cost for the basic
 * operations ({@code add}, {@code remove} and {@code contains}).
 * 
 * @author jorgecasariego
 *
 */
public class TreeVocabulary extends TreeSet<String> implements Vocabulary{
	
	
	public TreeVocabulary(){
		super();
	}
	
	/**
	 * TreeSet contain a A {@link NavigableSet} implementation based on a {@link TreeMap}
	 * @param s
	 */
	public TreeVocabulary(Collection<String> s){
		super(s);
	}

	@Override
	public boolean add(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrefix(String prefix) {
		/*
		 * The ceiling method is used to return the least element in this set
		 * greater than or equal to the given element, or null if there is
		 * no such element.
		 */
		String nextWord = ceiling(prefix);
		
		if(nextWord == null){
			return false;
		}
		
		if(nextWord.equals(prefix)){
			/*
			 * is used to a view of the portion of this set whose elements 
			 * are greater than (or equal to, if inclusive is true) fromElement.
			 */
			Set<String> tail = tailSet(nextWord, false);
			
			if(tail.isEmpty()){
				return false;
			}
			
			nextWord = tail.iterator().next();
		}
		
		return nextWord.startsWith(prefix);
	}

	@Override
	public boolean contains(String word) {
		return super.contains(word);
	}

	@Override
	public String getName() {
		return getClass().getName();
	}
	
}
