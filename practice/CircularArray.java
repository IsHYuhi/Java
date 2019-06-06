import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<T> implements Iterable<T>{

  private T[] _iterns;
  private int _head = 0;

  @SuppressWarnings({"unchecked"})
  public CircularArray(int size){
    _iterns = (T[])new Object[size];
  }

  public void set(int i, T itern){
    _iterns[convert(i)] = itern;
  }

  public T get(int i){
    if(i<0 || i>= _iterns.length){
      throw new java.lang.IndexOutOfBoundsException("out of bounds");
    }
    return _iterns[convert(i)];
  }

  public void rotate(int shift_right){
    _head = convert(shift_right);
  }

  @Override
  public Iterator<T> iterator(){
    return new CircularArrayIterator<T>(this);
  }

  private int convert(int index){
    if(index <0){
      index = index + _iterns.length;
    }

    return (_head + index) % _iterns.length;
  }

  private class CircularArrayIterator<TI> implements Iterator<TI>{
    private int _current = -1;
    private TI[] _iterns;

    public CircularArrayIterator(CircularArray<TI> circular_array){
      _iterns = circular_array._iterns;
    }

    @Override
    public boolean hasNext(){
        return (_current < _iterns.length-1);//currentのはじめが-1なので-1してる
    }

    @Override
    public TI next(){
      _current++;
      if(_current >= _iterns.length){
        throw new NoSuchElementException();
      }

      TI itern =_iterns[_current];
      return itern;
    }

    @Override
    public void remove(){
      throw new UnsupportedOperationException();
    }
  }

  public static void main(String[] args){
    int size = 10;
    CircularArray<Integer> array = new CircularArray<Integer>(size);
    for(int i = 0; i<size; i++){
      array.set(i,i);
    }

    array.rotate(5);

    for(Integer i : array){
      System.out.println(i);
    }
  }

}