package model.presentation;

import model.Pencil;

public interface PencilState {
	/**
	 * Render the pencil aspect
	 * @return render result like XML pieces
	 */
	Object getDrawing();

	/**
	 * Get the Pencil
	 * @return
	 */
	Pencil getPencil();


}
