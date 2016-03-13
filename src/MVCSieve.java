
public class MVCSieve {

	public static void main(String[] args) {
		SieveModel model = new SieveModel();
		SieveView view = new SieveView(model);
		model.AddView(view);
		SieveController controller = new SieveController(model);
		controller.sieve(model);

	}

}
