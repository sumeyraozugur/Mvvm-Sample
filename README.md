<h1 align="center">:bomb: Mvvm Sample :sweat_drops: </h1>

- [Basic Calculator](#1)
- [Calculator with View Model](#2)
- [Calculator with Live Data](#3)
- [Calculator with Repo](#4)

 <a name="1"></a> <h2 align="center">:orange_heart: Basic Calculator :heartpulse: </h2>

```Kotlin

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var number1: Int? = null
    private var number2: Int? = null
    private var result: Int? = null
    private lateinit var toastMessage: String

    companion object{
        private var isCheck: Boolean = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toastMessage = "Enter Numbers!!!"

        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)
  }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }

        Log.v("ChangeTheme", isCheck.toString())
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSum -> sumNumbers()
            R.id.btnSub -> subNumbers()
            R.id.btnMulti -> multiNumbers()
            R.id.btnDiv -> divNumbers()
        }
    }

    private fun sumNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            result = (number1!! + number2!!)
            binding.textResult.text = result.toString()
        }
   }

   
    private fun changeTheme() {
        isCheck = if (isCheck ) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
    }

}


```

### :fire: Notes

- ``` isCheck ``` should be static. İf yo don't  put  this  value static, you should click change theme part twice. 
- I define these variable in main activity. So You don't need define these again in functions. 
- <b>  Static variables </b> are created as soon as the project starts running and continue to run until the program terminates.The situation is different when creating the object. Occurs when the object is called and then it is deleted by garbage collector.
- :bangbang: <b>  Static variables  </b>  are not suitable for object oriented programming. Also it  increases addictions.
 

<a name="2"></a><h2 align="center">:orange_heart: Calculator with View Model :heartpulse: </h2>


```Kotlin

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var number1: Int? = null
    private var number2: Int? = null
    private lateinit var toastMessage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toastMessage = "Enter Numbers!!!"
        binding.textResult.text = viewModel.result

        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSum -> sumNumbers()
            R.id.btnSub -> subNumbers()
            R.id.btnMulti -> multiNumbers()
            R.id.btnDiv -> divNumbers()
        }
    }

    private fun sumNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sum(number1.toString(), number2.toString())
            binding.textResult.text = viewModel.result
        }
    }

    private fun changeTheme() {
        viewModel.checkThem()

    }
}


```


```Kotlin

class MainViewModel:ViewModel() {
    var result = "0"
    
    companion object{
        var isCheck:Boolean = true
    }

    fun sum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 +num2
        result = sum.toString()
    }


    fun checkThem(){
        isCheck = if (isCheck) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }

    }

}



```

###  :fire:Notes

- ViewModel class  should inherit  ViewModel() class.
- General operations are done in the view model, then these operations are called from MainActivity



 <a name="3"></a><h2 align="center">:orange_heart:  Calculator with Live Data  :heartpulse:  </h2>


```Kotlin

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var number1: Int? = null
    private var number2: Int? = null
    private lateinit var toastMessage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toastMessage = "Enter Numbers!!!"

        viewModel.result.observe(this) {
            binding.textResult.text = it
        }


        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSum -> sumNumbers()
            R.id.btnSub -> subNumbers()
            R.id.btnMulti -> multiNumbers()
            R.id.btnDiv -> divNumbers()

        }
    }

    private fun sumNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sum(number1.toString(), number2.toString())

        }
    }

    private fun changeTheme() {
        viewModel.checkThem()

    }
}


```


```Kotlin

class MainViewModel:ViewModel() {
    var result = MutableLiveData<String>()
    var isCheck =MutableLiveData<Boolean>()

    init {
        isCheck = MutableLiveData<Boolean>(true)
    }

    fun sum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 +num2
        result.value= sum.toString()
    }

    fun checkThem(){
        isCheck.value= if (isCheck.value==true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
    }
}

```

### :fire: Notes

#### What is the difference between LiveData and MutableLiveData?

- LiveData is immutable while MutableLiveData is mutable. So we can observe and set the values using postValue() and setValue() methods in MutableLiveData. Namely when you don't want your data to be modified use LiveData If you want to modify your data later use MutableLiveData.
- MutableLİveData is a subclass of LiveData. 
- In init function, you can initialize these values.
- Cause you are using live data, you can observe this data
- In here, you start to use  `` .value  ``


<a name="4"></a><h2 align="center">:orange_heart: Calculator with Repo  :heartpulse:  </h2>


```Kotlin

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var number1: Int? = null
    private var number2: Int? = null
    private lateinit var toastMessage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toastMessage = "Enter Numbers!!!"

        viewModel.result.observe(this) {
            binding.textResult.text = it
        }


        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSum -> sumNumbers()
            R.id.btnSub -> subNumbers()
            R.id.btnMulti -> multiNumbers()
            R.id.btnDiv -> divNumbers()
        }
    }

    private fun sumNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sum(number1.toString(), number2.toString())

        }
    }

    private fun changeTheme() {
        viewModel.checkThem()

    }
}


```


```Kotlin

class MainViewModel : ViewModel() {
    var result = MutableLiveData<String>()
    var isCheck = MutableLiveData<Boolean>()
    var mRepo = Repository()

    init {
        isCheck = mRepo.isCheck
        // result = mRepo.mathResult()
        result = mRepo.mathResult
    }

    fun sum(number1: String, number2: String) {
        mRepo.sumNum(number1, number2)
    }

    fun checkThem() {
        mRepo.controlThem()
    }
}


```


```Kotlin

class Repository {
    var mathResult = MutableLiveData<String>()
    var isCheck = MutableLiveData<Boolean>()

    init {
        isCheck = MutableLiveData<Boolean>(true)
        mathResult = MutableLiveData<String>("0")
    }

    fun mathResult(): MutableLiveData<String> {
        return mathResult
    }

    fun sumNum(number1: String, number2: String) {
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 + num2
        mathResult.value = sum.toString()
    }


    fun controlThem() {
        isCheck.value = if (isCheck.value == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
    }
}


```

### :fire: Notes

- Repo connects with ViewModel, ViewModel connect with (Activity or Fragment)


