/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renad khateeb
 */
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Use JAXP DOM Parser to display all persons: title, names...
 * 
 * @author Huseyin OZVEREN
 */
public class TestParsingXmlWithDOM {

	public static void main(String[] args) throws Exception {

		// Create a DOM parser factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Obtain a DOM builder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		// XML Stream
		InputStream xmlStream = TestParsingXmlWithDOM.class.getResourceAsStream("people2.xml");
		
		// Parse the given XML document 
		// in order to build a DOM tree representing the XML document
		Document doc = docBuilder.parse(xmlStream);

		// Return all the person elements as NodeList
		//NodeList personNodes = doc.getElementsByTagName("person"); 
		// Return the root element
		//Element root = doc.getDocumentElement();  

		// Get a list of all elements in the document
		// The wild card * matches all tags
		NodeList list = doc.getElementsByTagName("*");
                ArrayList<UserProfile> people = new ArrayList<UserProfile> ();

		int friendCount = 0;
                
                String id ="";
		for (int i = 0; i < list.getLength(); i++) {
			
			// Get the elements person (attribute ID), title, names...
			Element element = (Element) list.item(i);
			String nodeName = element.getNodeName();
			if (nodeName.equals("user")) {
		            UserProfile user = new UserProfile();
                            user.setId(Integer.parseInt(element.getAttribute("ID")));
               // System.out.println(user.getId());
                            people.add(friendCount,user);
                            friendCount++;
                                
                        }
                        else if (nodeName.equals("firstname")) {
				people.get(friendCount-1).setFirstName( element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("lastname")) {
                                people.get(friendCount-1).setLastName( element.getChildNodes().item(0).getNodeValue());
			}
                          else if (nodeName.equals("Gender")) {
				people.get(friendCount-1).setGender( element.getChildNodes().item(0).getNodeValue());
			}

                        else if (nodeName.equals("birthdate")) {
				people.get(friendCount-1).setBirthdate( element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("x")) {
				people.get(friendCount-1).setX( element.getChildNodes().item(0).getNodeValue());
			}
                        else if (nodeName.equals("y")) {
				people.get(friendCount-1).setY( element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("address")) {
				people.get(friendCount-1).setAddress( element.getChildNodes().item(0).getNodeValue());
			}
                        else if (nodeName.equals("hobbies")) {
				people.get(friendCount-1).setHobbies( element.getChildNodes().item(0).getNodeValue());
			}
                       else if (nodeName.equals("nationality")) {
				people.get(friendCount-1).setNationality( element.getChildNodes().item(0).getNodeValue());
			}
                
                        
                        
			
                //parsing 
                	// Create a DOM parser factory
		DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
		// Obtain a DOM builder
		DocumentBuilder docBuilder1 = factory1.newDocumentBuilder();

		// XML Stream
		InputStream xmlStream1 = TestParsingXmlWithDOM.class.getResourceAsStream("relation.xml");
		
		// Parse the given XML document 
		// in order to build a DOM tree representing the XML document
		Document doc1 = docBuilder.parse(xmlStream);

		// Return all the person elements as NodeList
		//NodeList personNodes = doc.getElementsByTagName("person"); 
		// Return the root element
		//Element root = doc.getDocumentElement();  

		// Get a list of all elements in the document
		// The wild card * matches all tags
                
                
                
                
                
                
		NodeList list1 = doc.getElementsByTagName("*");

                int id1 =0;
                
               
                
		for (int j = 0; j < list1.getLength(); j++) {
			
			// Get the elements person (attribute ID), title, names...
			Element element1 = (Element) list1.item(i);
			String nodeName1= element.getNodeName();
                        
                        if(nodeName.equals("person_id")){
                
                        
                id1=Integer.parseInt(element.getChildNodes().item(0).getNodeValue());
               // System.out.println(id);
            }else if(nodeName.equals("friend_id")){ 
                int id2;
                id2= Integer.parseInt(element.getChildNodes().item(0).getNodeValue());
                people.get(id2-1).friendrelations.add(people.get(id1-1));
                people.get(id1-1).friendrelations.add(people.get(id2-1));
            }
                }
			
                         
			
                        
                        if (nodeName.equals("user")) {
				friendCount++;
//				System.out.println("User Name " + peopleCount);
				String personId = element.getAttribute("ID");
				System.out.println("\tID:\t" + personId);
                                
			
			}  else if (nodeName.equals("firstname")) {
				System.out.println("\tfirst name:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("lastname")) {
				System.out.println("\tlast name:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                          else if (nodeName.equals("Gender")) {
				System.out.println("\tGender:\t" + element.getChildNodes().item(0).getNodeValue());
			}

                        else if (nodeName.equals("birthdate")) {
				System.out.println("\tBirth Date:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("x")) {
				System.out.println("\t x coordinate:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                        else if (nodeName.equals("y")) {
				System.out.println("\t Y coordinate:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                         else if (nodeName.equals("address")) {
				System.out.println("\t address:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                        else if (nodeName.equals("hobbies")) {
				System.out.println("\t hobbies:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                       else if (nodeName.equals("nationality")) {
				System.out.println("\t nationality:\t" + element.getChildNodes().item(0).getNodeValue());
                                
                                System.out.println("\n");
			}
//                        for(int m =0 ; m<u.friends.size() ; m++){
//                        System.out.println(" \t\tFriend "+ (m+1) +": "+u.friends.get(m).getFirstName()+" "+
//                                                             u.friends.get(m).getLastName());
           }
        }
                
                
                
                
	

static class UserProfile{
    private int ID;
    private String firstName;
    private String lastName;
    private String Gender;
    private String Birthdate;
    private String x;
    private String y;
    private String address;
    private String hobbies;
    private String nationality;
    public ArrayList friendrelations;
    
    
    
    public int getId(){
        return ID;
    }
    public void setId(int ID){
        this.ID= ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    
    public UserProfile(){
        friendrelations = new ArrayList<UserProfile>();
    }

       
            
            
}}
        
	




