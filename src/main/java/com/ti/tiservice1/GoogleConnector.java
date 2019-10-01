/**
 * 
 */
package com.ti.tiservice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.sql.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket.BlobWriteOption;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1.Page;

/**
 * @author duansubramaniam
 *
 */
public class GoogleConnector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		Storage storage = StorageOptions.newBuilder()
			    .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("/Users/duansubramaniam/Documents/duan/company/avora/sshkeys/gcskeys/sa.json")))
			    .build()
			    .getService();
		
		System.out.println("getting bucket inro");
		
		com.google.api.gax.paging.Page<Blob> list = storage.list("avora-etl", BlobListOption.currentDirectory());
		for (Blob blob : list.getValues()) {
			System.out.println("bucket: " + blob.getBucket());
			System.out.println("bucket: " + blob.getName());
			System.out.println("bucket: " + blob.getStorage());
			ReadChannel readChannel = blob.reader();
			FileOutputStream fileOuputStream = new FileOutputStream("/Users/duansubramaniam/Documents/duan/company/avora/dowloadedfile1.txt");
			fileOuputStream.getChannel().transferFrom(readChannel, 0, Long.MAX_VALUE);
			fileOuputStream.close();
			
			
//			WriteChannel writeChannel = blob.writer();
//			FileInputStream fileInputStream = new FileInputStream("/Users/duansubramaniam/workspace_avora/Test1_dev/data-in/input.txt");
//			fileInputStream.getChannel().transferTo( 0, Long.MAX_VALUE,writeChannel);
//			fileInputStream.close();
			// /Users/duansubramaniam/workspace_avora/Test1_dev/data-in
		}
		String bucketName = "avora-etl";
		 String blobName = "input2.txt";
		 BlobId blobId = BlobId.of(bucketName, blobName);
		 byte[] content = "New file!".getBytes();
		 BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
		 try (WriteChannel writer = storage.writer(blobInfo)) {
		   try {
		     //writer.write(ByteBuffer.wrap(content, 0, content.length));
			   FileInputStream fileInputStream = new FileInputStream("/Users/duansubramaniam/workspace_avora/Test1_dev/data-in/input2.txt");
				fileInputStream.getChannel().transferTo( 0, Long.MAX_VALUE,writer);
				fileInputStream.close();
		   } catch (Exception ex) {
		     // handle exception
		   }
		 }
		System.out.println("bucket: " + list);
		
		}catch(Exception e) {
			System.out.println("error : " + e);
		}
	}
		
//		GoogleCredential credential =GoogleCredential.fromStream(new FileInputStream("MyProject-1234.json"));
//PrivateKey privateKey = credential.getServiceAccountPrivateKey();
//String privateKeyId = credential.getServiceAccountPrivateKeyId();
//
//long now = System.currentTimeMillis();
//
//try {
//    Algorithm algorithm = Algorithm.RSA256(null, privateKey);
//    String signedJwt = JWT.create()
//        .withKeyId(privateKeyId)
//        .withIssuer("123456-compute@developer.gserviceaccount.com")
//        .withSubject("123456-compute@developer.gserviceaccount.com")
//        .withAudience("https://firestore.googleapis.com/google.firestore.v1beta1.Firestore")
//        .withIssuedAt(new Date(now))
//        .withExpiresAt(new Date(now + 3600 * 1000L))
//        .sign(algorithm);
//} catch(Exception e) {
//
//	}

}
