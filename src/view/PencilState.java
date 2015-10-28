package view;

public interface PencilState {
    /**
     * Render the pencil aspect
     * @param pencil
     * @return render result like XML pieces
     */
    Object getDrawing();
    
    /**
     * Get the Pencil
     * @return
     */
    Object getPencil();

    
}
