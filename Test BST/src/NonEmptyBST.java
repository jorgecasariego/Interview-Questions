
class NonEmptyBST<D extends Comparable> implements Tree<D> {
	D data;
	Tree<D> left;
	Tree<D> right;
	
	public NonEmptyBST(D element) {
		data = element;
		left = new EmptyBST<D>();
		right = new EmptyBST<D>();
	}
	
	public NonEmptyBST(D element, Tree<D> left, Tree<D> right) {
		this.data = element;
		this.left = left;
		this.right = right;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public int cardinality() {
		return 1 + left.cardinality() + right.cardinality();
	}
	public boolean member(D element) {
		if(data == element){
			return true;
		} else {
			if(element.compareTo(data) < 0){
				return left.member(element);
			} else {
				return right.member(element);
			}
		}
	}
	
	public NonEmptyBST<D> add(D element) {
		if(data == element) {
			return this;
		} else {
			if(element.compareTo(data) < 0) {
				return new NonEmptyBST(data, left.add(element), right);
			} else {
				return new NonEmptyBST(data, left, right.add(element));
			}
		}
	}
	
	
}
