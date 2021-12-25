package NonLinear.BinaryTree.Model;

import java.util.Objects;

public class Obj extends TreeObject<Obj> {

    private int data;

    Obj(int data){
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(data, obj.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public int compareTo(Obj thing) {
        int i = 0;
        if(this.getData() > thing.getData()){
            i = 1;
        }else if(this.getData() < thing.getData()){
            i = -1;
        }
        return i;
    }

    @Override
    public String toString() {
        return String.format("%d", data);
    }
    
    public int getData(){
        return this.data;
    }

    public void setData(int newData){
        this.data = newData;
    }

}
