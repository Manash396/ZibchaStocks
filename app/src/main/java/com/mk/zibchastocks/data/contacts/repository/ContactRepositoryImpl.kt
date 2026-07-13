    package com.mk.zibchastocks.data.contacts.repository

    import com.mk.zibchastocks.data.contacts.remote.datasource.ContactRemoteDataSource
    import com.mk.zibchastocks.domain.contacts.model.Contact
    import com.mk.zibchastocks.domain.contacts.repository.ContactRepository
    import com.mk.zibchastocks.util.Result
    import javax.inject.Inject

    class ContactRepositoryImpl @Inject constructor(
        private val dataSource: ContactRemoteDataSource
    ) : ContactRepository{
        override suspend fun getContactList(): Result<List<Contact>> {
            return Result.Success(
                data = contactList
            )
        }




        val contactList = listOf(
            Contact("Amit Sharma", "9876543210"),
            Contact("Riya Das", "9123456780"),
            Contact("Rahul Verma", "9988776655"),
            Contact("Sneha Roy", "9090909090"),
            Contact("Arjun Singh", "8765432109"),
            Contact("Priya Mehta", "9345678901"),
            Contact("Vikash Kumar", "9898989898"),
            Contact("Neha Gupta", "9111222333"),
            Contact("Karan Patel", "9222333444"),
            Contact("Anjali Singh", "9333444555"),
            Contact("Rohit Yadav", "9444555666"),
            Contact("Pooja Sharma", "9555666777"),
            Contact("Deepak Mishra", "9666777888"),
            Contact("Simran Kaur", "9777888999"),
            Contact("Manish Jain", "9888999000"),
            Contact("Kavita Joshi", "9000111222"),
            Contact("Suresh Reddy", "9111222444"),
            Contact("Nikita Paul", "9222333555"),
            Contact("Aditya Sen", "9333444666"),
            Contact("Meera Nair", "9444555777"),
            Contact("Priya Mehta", "9345678901"),
            Contact("Vikash Kumar", "9898989898"),
            Contact("Neha Gupta", "9111222333"),
            Contact("Karan Patel", "9222333444"),
            Contact("Anjali Singh", "9333444555"),
            Contact("Rohit Yadav", "9444555666"),
            Contact("Pooja Sharma", "9555666777"),
            Contact("Deepak Mishra", "9666777888"),
            Contact("Simran Kaur", "9777888999"),
            Contact("Manish Jain", "9888999000"),
            Contact("Kavita Joshi", "9000111222"),
            Contact("Suresh Reddy", "9111222444"),
            Contact("Nikita Paul", "9222333555"),
            Contact("Aditya Sen", "9333444666"),
            Contact("Meera Nair", "9444555777")
        )

    }