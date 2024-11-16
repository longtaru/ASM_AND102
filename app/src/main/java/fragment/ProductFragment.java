package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import adapter.ProductAdapter;
import mob.longnd.asm.DAO.SanPhamDAO;
import mob.longnd.asm.R;
import mob.longnd.asm.model.Product;

public class ProductFragment extends Fragment {
    RecyclerView recyclerProduct;
    FloatingActionButton floatAdd;
    SanPhamDAO sanPhamDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        recyclerProduct=view.findViewById(R.id.recyclerProduct);
        floatAdd=view.findViewById(R.id.floatAdd);

        sanPhamDAO = new SanPhamDAO(getContext());
        ArrayList<Product> list = sanPhamDAO.getDS();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerProduct.setLayoutManager(linearLayoutManager);
        ProductAdapter adapter = new ProductAdapter(getContext(), list);
        recyclerProduct.setAdapter(adapter);


        return view;
    }
}
