package collection_observer;

/**
 * 
 * @author M Faisal Hameed Niazi
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("rawtypes")
public class ObservableList extends ArrayList
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private ArrayList			observers			= new ArrayList();
	private List				originalList		= new ArrayList();

	public ObservableList()
	{
	}

	@SuppressWarnings("unchecked")
	public ObservableList(List list)
	{
		super(list);
		this.originalList = list;
	}

	public ObservableList(int initialCapacity)
	{
		super(initialCapacity);
	}

	public Collection getOriginalList()
	{
		return originalList;
	}

	@SuppressWarnings("unchecked")
	public void addCollectionObserver(ICollectionObserver observer)
	{
		observers.add(observer);
	}

	public void removeCollectionObserver(ICollectionObserver observer)
	{
		observers.remove(observer);
	}

	protected void notifyItemAdded(Object o)
	{
		Iterator elements = observers.iterator();
		while (elements.hasNext())
		{
			((ICollectionObserver) elements.next()).itemAdded(o);
		}
	}

	protected void notifyItemRemoved(Object o)
	{
		Iterator elements = observers.iterator();
		while (elements.hasNext())
		{
			((ICollectionObserver) elements.next()).itemRemoved(o);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean add(Object o)
	{
		boolean result = super.add(o);
		if (originalList != null)
		{
			originalList.add(o);
		}
		notifyItemAdded(o);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#add(int, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public void add(int index, Object element)
	{
		super.add(index, element);
		if (originalList != null)
			originalList.add(index, element);
		notifyItemAdded(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#remove(java.lang.Object)
	 */
	public boolean remove(Object o)
	{
		boolean result = super.remove(o);
		if (originalList != null)
			originalList.remove(o);

		notifyItemRemoved(o);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#remove(int)
	 */
	public Object remove(int index)
	{
		Object result = null;
		if (originalList != null )
		{
			originalList.remove(index);
			notifyItemRemoved(result);
		}
		return result;
	}

	public void replace(Object from, Object to)
	{
		if (originalList != null)
		{
			int idx = originalList.indexOf(from);
			if (idx != -1)
			{
				remove(idx);
				add(idx, to);
			}
		}
	}

	public void clear()
	{
		super.clear();
		for (int i = 0; i < originalList.size(); i++)
		{
			remove(i);
		}
	}

	public int countObservers()
	{
		return observers.size();
	}

}