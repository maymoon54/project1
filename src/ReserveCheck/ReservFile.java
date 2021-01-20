package ReserveCheck;

public class ReservFile {

	String id;
	String subject;
	int reserv_num;
	String region;
	String date;
	String room_num;
	String time;
	String seat_num;
	public ReservFile(String id, String subject, int reserv_num, String region, String date, String room_num,
			String time, String seat_num) {
		super();
		this.id = id;
		this.subject = subject;
		this.reserv_num = reserv_num;
		this.region = region;
		this.date = date;
		this.room_num = room_num;
		this.time = time;
		this.seat_num = seat_num;
	}
	@Override
	public String toString() {
		return "예매내역 [id=" + id + ", subject=" + subject + ", reserv_num=" + reserv_num + ", region="
				+ region + ", date=" + date + ", room_num=" + room_num + ", time=" + time + ", seat_num=" + seat_num
				+ "]";
	}
}
