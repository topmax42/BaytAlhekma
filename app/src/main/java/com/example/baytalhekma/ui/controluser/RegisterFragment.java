package com.example.baytalhekma.ui.controluser;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.baytalhekma.Models.RegisterModel;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.R;
import com.example.baytalhekma.api.RetrofitClientS;
import com.example.baytalhekma.databinding.FragmentRegisterBinding;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterFragment extends Fragment implements
        AdapterView.OnItemSelectedListener {
    String[] university = { "Cairo University", "Alexandria University", "Harvard University"};

    private ArrayAdapter spinAdapter;

    SharedPreferences userPref;
    SharedPreferences.Editor editor;

    FragmentRegisterBinding binding;
    NavController navCon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navCon = Navigation.findNavController(view);
        initial();
        onClick();
        setUpSpinner();
        onTextChanging();
        register();


    }
    private void initial() {


        userPref = getActivity().getSharedPreferences("userprefs", Context.MODE_PRIVATE);
        editor= userPref.edit();

        binding.registerUniversity.setOnItemSelectedListener(this);
        spinAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, university);


        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        //        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    RegisterModel r;

    private void register() {
        binding.buttonRegister.setOnClickListener(v -> {

            String name = binding.registerName.getText().toString();
            String email = binding.registerEmail.getText().toString();
            String pass = binding.registerEmail.getText().toString();
            String phone = binding.registerPhone.getText().toString();



            if ((!(name.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty()))
                    && email.contains("@") && phone.length() == 11) {

                Call<RegisterModel> call = RetrofitClientS.getInstance().
                        getMyApi().register(name, email, pass, phone, "1");
                call.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

                        Log.e("WWS", new Gson().toJson(response.body()));
                        r = response.body();
//                        Toast.makeText(RegisterActivity.this,
//                                r.getData().getToken()
//                                , Toast.LENGTH_SHORT).show();
                        User.setInstace(new User(r.getData().getName(),r.getData().getEmail(),
                                r.getData().getMobile(),r.getData().getId()));
                        User.getInstance().setToken(r.getData().getToken());


//
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                        Log.e("Err", new Gson().toJson(t.getMessage()));
                        Toast.makeText(getActivity(),"network error", Toast.LENGTH_SHORT).show();

                    }
                });
            }
            else
            {
                Toast.makeText(getActivity(),"register error", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getActivity(),User.getInstance().getMobile(), Toast.LENGTH_SHORT).show();
//            Call<RegisterModel> call2 = RetrofitClientS.getInstance().
//                    getMyApi().otpVerify(Integer.parseInt(r.getData().getOtp()),
//                            r.getData().getToken());
//            call2.enqueue(new Callback<RegisterModel>() {
//                                @Override
//                                public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//                                    Toast.makeText(RegisterActivity.this, "register success", Toast.LENGTH_SHORT).show();
//                                    LoginManagement lm = new LoginManagement(RegisterActivity.this);
//
//                                    RegisterModel r = response.body();
//                                    User.setInstace( new User(r.getData().getName(),r.getData().getEmail(),
//                                            r.getData().getMobile(),r.getData().getId()));
//
//                                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
//                                    i.putExtra("obj", User.getInstance());
//                                    lm.keepSession(User.getInstance());
//                                    editor.putString("user",new Gson().toJson(User.getInstance())).commit();
//
//                                    startActivity(i);
//                                }
//                                @Override
//                                public void onFailure(Call<RegisterModel> call, Throwable t) {}
//                            });

        });

    }

    private void onTextChanging() {
        binding.registerPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
                //Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");



                if(binding.registerPassword.getText().toString()!=null)
                {
                    Matcher m = p.matcher(binding.registerPassword.getText().toString());
                    if(!m.matches())

                    {
                        binding.regPasswordValidation.setText("?????? ???? ?????????? ?????? ???????? ?????????? ?? ??????????");
                    }
                    else
                    {
                        binding.regPasswordValidation.setText("");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        binding.registerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(binding.registerName.getText().toString()!=null)
                {
                    if(!binding.registerName.getText().toString().contains(" "))
                    {
                        binding.regNameValidation.setText("???????? ?????????? ??????????????");
                    }
                    else
                    {
                        binding.regNameValidation.setText("");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        binding.registerEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(binding.registerEmail.getText().toString()!=null)
                {
                    if(!(binding.registerEmail.getText().toString().contains("@") &&
                            binding.registerEmail.getText().toString().endsWith(".com")))
                    {
                        binding.regEmailValidation.setText("???????? ???????? ???????????????? ????????");
                    }
                    else
                    {
                        binding.regEmailValidation.setText("");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        binding.registerPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(binding.registerPhone.getText().toString()!=null)
                {
                    if(!(binding.registerPhone.getText().toString().length() == 11))
                    {
                        binding.regPhoneValidation.setText("???????? ?????? ???????? ????????");
                    }
                    else
                    {
                        binding.regPhoneValidation.setText("");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void setUpSpinner() {
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.registerUniversity.setAdapter(spinAdapter);
    }

    private void onClick() {
        binding.gotoLoginnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetoLogin();
            }
        });
        binding.backreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navCon.popBackStack();
            }
        });
    }





    private  void movetoLogin(){
        //Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
        //startActivity(i);
        //finish();
        navCon.navigate(R.id.action_registerFragment_to_loginnFragment);
    }

    //Performing action onItemSelected and onNothing selected for the spinner
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void dispatchTouchEvent() {
        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }

    }
    public Boolean getInstance()
    {
        if(this.isAdded())
        {return true;}
        else{
        return null;}
    }

}
