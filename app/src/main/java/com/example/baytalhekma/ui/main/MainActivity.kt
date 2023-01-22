package com.example.baytalhekma.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.baytalhekma.Models.User
import com.example.baytalhekma.R
import com.example.baytalhekma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        //binding!!.bottomNavigation.selectedItemId = R.id.learn
        //navController = findNavController(this, R.id.fragmentContainerView2)
        setupNavController()


        //User u = (User) getIntent().getSerializableExtra("obj");
        //Toast.makeText(MainActivity.this,String.valueOf(u.getMobile()),Toast.LENGTH_LONG).show();
        Toast.makeText(this@MainActivity, User.getInstance().email.toString(), Toast.LENGTH_LONG)
            .show()

        //replaceFragment(new Learn(),u);

        //BottomNavigationView bottombar = findViewById(R.id.bottom_navigation);

        //bottombar.setSelectedItemId(R.id.itemLearn
//        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId())
//                {
//                    case R.id.itemMyAccount:
//                        replaceFragment(new MyAccount(),u);
//                        return true;
//                    case R.id.itemLearn:
//                        replaceFragment(new Learn(),u);
//                        return true;
//                    case R.id.itemTeachers:
//                        replaceFragment(new Teachers(),u);
//                        return true;
//                    case R.id.itemTranslate:
//                        replaceFragment(new Translate(),u);
//                        return true;
//                    case R.id.itemEexplore:
//                        replaceFragment(new Explore(),u);
//                        return true;
//
//                }
//                return false;
//            }
//        });
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        //setupWithNavController(binding!!.bottomNavigation, navController!!)
    }

    private fun replaceFragment(fragment: Fragment, u: User) {
        val b = Bundle()
        b.putSerializable("a", u)
        fragment.arguments = b
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

    private fun setupNavController() {


        val bottomNavView = binding?.bottomNavigation
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavView?.setupWithNavController(navController)

    }
}