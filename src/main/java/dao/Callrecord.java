package dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Callrecord {

	@Id
	@Column(name="callid")
	private long id;
	@Column(updatable = false, insertable = false)
	private long origdestination;
	private String origin;
	
//	@Temporal(TemporalType.TIMESTAMP)
	private String callstart;
	private String queuestart;
	
//	@Temporal(TemporalType.TIMESTAMP)
	private String callend;
	
	private String disconnecttime;
	private String calltypekey;
	private String calltypestepnum;
	private String contacttype;
	private String termtype;
	private String answeringagent;
	private String queueend;
	private String waittime;
	private String waitresolution;
	private String caption;
	private String redirect;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrigdestination() {
		return origdestination;
	}
	public void setOrigdestination(long origdestination) {
		this.origdestination = origdestination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCallstart() {
		return callstart;
	}
	public void setCallstart(String callstart) {
		this.callstart = callstart;
	}
	public String getQueuestart() {
		return queuestart;
	}
	public void setQueuestart(String queuestart) {
		this.queuestart = queuestart;
	}
	public String getCallend() {
		return callend;
	}
	public void setCallend(String callend) {
		this.callend = callend;
	}
	public String getDisconnecttime() {
		return disconnecttime;
	}
	public void setDisconnecttime(String disconnecttime) {
		this.disconnecttime = disconnecttime;
	}
	public String getCalltypekey() {
		return calltypekey;
	}
	public void setCalltypekey(String calltypekey) {
		this.calltypekey = calltypekey;
	}
	public String getCalltypestepnum() {
		return calltypestepnum;
	}
	public void setCalltypestepnum(String calltypestepnum) {
		this.calltypestepnum = calltypestepnum;
	}
	public String getContacttype() {
		return contacttype;
	}
	public void setContacttype(String contacttype) {
		this.contacttype = contacttype;
	}
	public String getTermtype() {
		return termtype;
	}
	public void setTermtype(String termtype) {
		this.termtype = termtype;
	}
	public String getAnsweringagent() {
		return answeringagent;
	}
	public void setAnsweringagent(String answeringagent) {
		this.answeringagent = answeringagent;
	}
	public String getQueueend() {
		return queueend;
	}
	public void setQueueend(String queuend) {
		this.queueend = queuend;
	}
	public String getWaittime() {
		return waittime;
	}
	public void setWaittime(String waittime) {
		this.waittime = waittime;
	}
	public String getWaitresolution() {
		return waitresolution;
	}
	public void setWaitresolution(String waitresolution) {
		this.waitresolution = waitresolution;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
}
