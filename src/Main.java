
public class Main {
	public static void main(String[] args) {
		Utils utils = new Utils();
		String resp = utils.loadUserloggedInData();
		if (!resp.isEmpty()) {
			Home hm = new Home();
			hm.setVisible(true);
		} else {
			SignIn si = new SignIn();
			si.setVisible(true);
		}

	}
}
