package mob.longnd.asm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import mob.longnd.asm.DAO.NguoiDungDAO;

public class SignupActivity extends AppCompatActivity {
    NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edUser = findViewById(R.id.edtUser);
        EditText edPass = findViewById(R.id.edtPass);
        EditText edRepass = findViewById(R.id.edt_repass);
        EditText edFullname = findViewById(R.id.edt_fullname);
        Button btnSignup = findViewById(R.id.btn_signup);
        Button btnBack = findViewById(R.id.btn_back);

        nguoiDungDAO = new NguoiDungDAO(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();
                String repass = edRepass.getText().toString();
                String fullname = edFullname.getText().toString();

                if (!pass.equals(repass)) {
                    Toast.makeText(SignupActivity.this, "Nhap mat khau khong khop, Kiem tra lai.", Toast.LENGTH_SHORT).show();
                } else {
                    boolean check = nguoiDungDAO.Register(user,pass,fullname);
                    if (check) {
                        Toast.makeText(SignupActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(SignupActivity.this, "Dang ky that bai! ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}