package com.wtx
import org.apache.spark.sql.SparkSession
/**
  * Created with IntelliJ IDEA. 
  * User: wutianxiong 
  * Date: 2018/11/28 
  * Time: 16:20 
  */
object SqlTest {
  def main(args: Array[String]): Unit = {
    //hive warehouse在hdfs上的存储目录
    val warehouse = "/user/hive/warehouse"

    val path = "/home/zmk/hdfs"
    val spark = SparkSession
      .builder()
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouse)
      .enableHiveSupport()
      .getOrCreate()

    val sql="select * from bigdat.antciflow where year=2018 and month=05 and day=10 and hour =12 limit 10;"

    val data=spark.sql(sql)
    //显示查询结果
    data.show
    //将结果保存至HDFS
    data.coalesce(1).write.save(path)
    spark.stop()
  }
}
