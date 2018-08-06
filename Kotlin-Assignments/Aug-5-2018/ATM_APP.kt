class Account(val accountName:String, val accountPin:String ="abcd",var accountInitialDepositAmount:Int=1000)


  /*  constructor(accountName:String, accountPin:String ="abcd", accountInitialDepositAmount:String="1000"){
    this.accountName = accountName
    this.accountPin = accountPin
    this.accountInitialDepositAmount = accountInitialDepositAmount

}*/


val accounts = arrayListOf<Account>()
var loginAccount: String =""
var loginPass: String = ""
var accountbalance: Int = 0
fun main(args: Array<String>) {

    mainMenu()

}
fun mainMenu(){
    println("""
        1. Add Account
        2. Login Account
    """.trimIndent())
    when(readLine()!!.toInt()){
        1 -> add()
        2 -> login()
    }
}

fun add(){

    println("Enter Account Name then Account Pin")
    accounts.add(Account(readLine()!!,readLine()!!))
    mainMenu()
}

fun login(){
    loginAccount = readLine()!!
    loginPass = readLine()!!
    var accountbalance: Int
    for(i in accounts){

        if(i.accountName==loginAccount){
            if(i.accountPin==loginPass){
                println("$loginAccount and your password is $loginPass and currently your account have ${i.accountInitialDepositAmount}")
                accountbalance = i.accountInitialDepositAmount
            }
        }
    }
    println("""
        1. Cash With Drawl
        2. Account Balance Inquiry
        3. Deposite
        4. logout
    """.trimIndent())
    when(readLine()!!.toInt()){
        1 -> cashWithDrawl()
        2 -> accountBalanceInquiry()
        3 -> deposite()
        4 -> logout()
    }

}
fun cashWithDrawl() {
    println("How much cash do you want to with drawl?")

    var cashToWithDrawl = readLine()!!.toInt()
    for (i in accounts) {

        if (i.accountName == loginAccount) {
            if (i.accountPin == loginPass) {
                accountbalance = i.accountInitialDepositAmount
            }
        }
        accountbalance -= cashToWithDrawl
        i.accountInitialDepositAmount = accountbalance
        println("You have With Drawl $cashToWithDrawl and your remaining amount is $accountbalance")
    }
    println("""

        1. Cash With Drawl
        2. Account Balance Inquiry
        3. Deposite
        4. logout
    """.trimIndent())
    when (readLine()!!.toInt()) {
        1 -> cashWithDrawl()
        2 -> accountBalanceInquiry()
        3 -> deposite()
        4 -> logout()
    }
}


fun accountBalanceInquiry(){
    println("your current account balance is $accountbalance")
    println("""

        1. Cash With Drawl
        2. Account Balance Inquiry
        3. Deposite
        4. logout
    """.trimIndent())
    when (readLine()!!.toInt()) {
        1 -> cashWithDrawl()
        2 -> accountBalanceInquiry()
        3 -> deposite()
        4 -> logout()
    }
}
fun deposite(){
    println("How much cash do you want to deposit?")

    var cashToWithDeposit = readLine()!!.toInt()
    for(i in accounts){

        if(i.accountName==loginAccount){
            if(i.accountPin==loginPass){
                accountbalance = i.accountInitialDepositAmount
            }
        }
        accountbalance += cashToWithDeposit
        i.accountInitialDepositAmount = accountbalance
        println("You have Deposited $cashToWithDeposit and your amount is $accountbalance")
    }
    println("""

        1. Cash With Drawl
        2. Account Balance Inquiry
        3. Deposite
        4. logout
    """.trimIndent())
    when (readLine()!!.toInt()) {
        1 -> cashWithDrawl()
        2 -> accountBalanceInquiry()
        3 -> deposite()
        4 -> logout()
    }

}
fun logout(){
    loginAccount = ""
    loginPass = ""
    accountbalance = 0
    mainMenu()
}
