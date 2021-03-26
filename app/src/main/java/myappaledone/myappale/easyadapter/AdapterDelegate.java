package myappaledone.myappale.easyadapter;

import androidx.annotation.NonNull;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AdapterDelegate<T, VH extends RecyclerView.ViewHolder> {

    private Class<T> mModelClass;

    public AdapterDelegate(@NonNull Class<T> modelClass) {
        mModelClass = modelClass;
    }

    public final boolean canHandleModel(Object model) {
        return mModelClass.isAssignableFrom(model.getClass());
    }

    public int getViewType() {
        return mModelClass.getName().hashCode();
    }

    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent);

    public abstract void onBindViewHolder(T model, VH holder);

}
