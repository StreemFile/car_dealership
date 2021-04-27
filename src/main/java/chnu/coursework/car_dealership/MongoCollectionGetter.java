//package chnu.coursework.car_dealership;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by IntelliJ IDEA.
// * car_dealership.MongoCollectionGetter
// *
// * @Autor: vovamv
// * @DateTime: 27.03.2021|23:40
// * @Version MongoCollectionGetter: 1.0
// */
//
//@Component
//public class MongoCollectionGetter {
//
//    @Autowired
//    private MongoClient mongoClient;
//    public MongoCollection<Document> getCollection(String collectionName){
//        return  mongoClient.getDatabase("car_dealership")
//                .getCollection(collectionName);
//    }
//}
