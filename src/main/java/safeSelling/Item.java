package safeSelling;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="d_item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long id;
	private String title;
	private String description;
	private Double buyingPrice;
	private Double expectedPrice;
	
	@Transient
	private String tagList;
	
	@ElementCollection
	private List<String> tags;

	//We can use element collection by creating a separate table for the same
	//@ElementCollection
	//@CollectionTable(name = "employee_courses", joinColumns = @JoinColumn(name = "idemployee"))
	
	//Visibility Level
	//1-company
	//2-other company
	//3-area
	//4-city
	private int visibilityLevel;
	private String contactPreference;
	private String userName;

	public Item(){
		this(null,null,null);
	}

	public Item(String message){
		this(message, null, null);
	}

	public Item(String message, Double buyingPrice, Double expectedPrice){
		this.id=null;
		this.description=message;
		this.buyingPrice=buyingPrice;
		this.expectedPrice =expectedPrice;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) { this.id = id; }

	public Double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Double getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Double expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public int getVisibilityLevel() {
		return visibilityLevel;
	}

	public void setVisibilityLevel(int visibilityLevel) {
		this.visibilityLevel = visibilityLevel;
	}

	public String getContactPreference() {
		return contactPreference;
	}

	public void setContactPreference(String contactPreference) {
		this.contactPreference = contactPreference;
	} 
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTagList() {
		return tagList;
	}

	public void setTagList(String tagList) {
		this.tagList = tagList;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this,that,"id","message");
	}

	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this, "id", "message");
	}


}
