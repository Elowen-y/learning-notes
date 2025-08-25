������¼�����
1. UI �û����棨User interface����
	������Ӳ����ƣ�������GUI��ͼ���û����棩��UE���û����飩��ID��������ƣ���
   GUI ͼ���û����棨Graphical User Interface����
	����ͼ�η�ʽ��ʾ�ļ���������û����档
	
2. javax.swing��һϵ��ͼ���û�����Ŀؼ���java��⡣
	������
		JComponent��Container������,���JComponent���ഴ�������Ҳ������������������������������
	
		1. JFrame���ײ����������壩
			javax.swing.JFrame��
				���췽����
					JFrame() ����һ����ʼʱ���ɼ����´��塣
					JFrame(String title) ����һ���µġ���ʼ���ɼ��ġ�����ָ������� Frame��
					
				��Ա������
					void setVisible(boolean b) ���ô����Ƿ�ɼ�������Ĭ���ǲ��ɼ��ġ�
					
					void setSize(int width, int height) ���ô�С��
					
					Container getContentPane() ���ش˴���� contentPane ����
					
					void setDefaultCloseOperation(int operation) ���õ����������ϽǵĹر�ͼ��󣬳�������������Ĵ���
						������
							DO_NOTHING_ON_CLOSE����ִ���κβ�����
							HIDE_ON_CLOSE��Ĭ�ϡ����ص�ǰ���ڡ�
							DISPOSE_ON_CLOSE�����ص�ǰ���ڣ����ͷŴ���ռ�е�������Դ��
							EXIT_ON_CLOSE�������������ڵ�Ӧ�ó���
							
					void setBounds(int x, int y, int width, int height) �ƶ�������������С��
						���������������࣬�ݼ��
						
					void setResizable(boolean resizable) ���ô˴����Ƿ�����û�������С��Ĭ�Ͽ��ԡ�
					
					void setLayout(LayoutManager layout) ���ò��֡�		LayoutManager layout�ǲ��ֶ���
						������
							FlowLayout��������
								�ò�����������ռ�����Ⱥ�˳������������У����֮���Ĭ��ˮƽ�ʹ�ֱ��϶��5�����أ������СΪĬ�ϵ���Ѵ�С��
								
							BorderLayout���߽粼�֣�Ĭ�ϲ��֣�
								�߿򲼾ַ�Ϊ�����ϡ����������������
								������ĳ���ֵ��
									BorderLayout.NORTH������
									BorderLayout.SOUTH������
									BorderLayout.WEST������
									BorderLayout.EAST������
									BorderLayout.CENTER���м���
							
							GridBagLayout�����񲼾�
								eg��GridLayout  gridLayout = new GridLayout(3,3); // ����һ���������еı�񲼾ֶ���
							
							null���Զ��岼��
								ͨ���ؼ�����setBounds(x,y,width,height)
							
					frame.getContentPane().setBackground(Color.blue); // ���ô���������屳��ɫ
					
				ע�⣺����JFrame����ʱ�������롿���ô�СsetSize()�����ô��ڿɼ�setVisible(true)
				
			�������Ĵ�����
				��һ��ֱ�Ӵ���JFrame����󣬸ö������һ�����塣
				����������һ���࣬����̳���JFrame����ô���ഴ���Ķ���Ҳ��һ���������
				
		2. JPanel�����
			javax.swing.JPanel��
				���췽����
					JPanel()
					JPanel(LayoutManager layout)
					
			ʹ��JPanel�������,����������������,Ȼ�����������ӵ����������С�add

		3. JScrollPane����������
			javax.swing.JScrollPane��
				���췽����
					JScrollPane(Component view)������һ����ʾָ��������ݵ� JScrollPane��ֻҪ��������ݳ�����ͼ��С�ͻ���ʾˮƽ�ʹ�ֱ��������
					
			���԰�һ�������Ҳֻ����һ������������ı�������ӵ�һ�����������У�Ȼ��Ϳ���ͨ�����������ۿ��������
			
		4. JOptionPane�������ڷ���ص���Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի��򡣣�api�ĵ��鿴��
		
		
	�����
		�ı������
			1. JLabel����ǩ���
				���췽����
					JLabel(String text)	��ָ�����ı����� JLabel ����
					JLabel(Icon image) 	��ָ����ͼ�񴴽� JLabel ����
					JLabel(String text, int horizontalAlignment) ��������ָ���ı���ˮƽ���뷽ʽ�� JLabel ʵ����
						horizontalAlignment��LEFT��CENTER��RIGHT��LEADING �� TRAILING��
					
				��Ա������
					void setFont(Font font) ���ô���������塣
			
			
			2. JTextField���ı��������
				���췽����
					JTextField()������һ���µ��ı������ 
					JTextField(String text)������һ���µ��ı������ ����ָ���ı���Ϊ��ʼ�ı���
					JTextField(String text, int columns)������һ����ָ���ı����г�ʼ������ TextField��
					
				��Ա������
					String getText()�������ı���������
					
			3. JTextArea���ı���
				���췽����
					JTextArea(int rows, int columns)
					JTextArea(String text, int rows, int columns)
					
				��Ա������
					String getText() ���ش� TextComponent �а������ı���
					void setFont(Font f) ���õ�ǰ���塣
			
			4. JPassword����������
				���췽����
					JPasswordField()
					JPasswordField(int columns)
					JPasswordField(String text)
					JPasswordField(String text, int columns)
					
				��Ա������
					char[] getPassword() ���ش� TextComponent �����������ı���
		
		ѡ�������
			5. JButton����ť���
				���췽����
					JButton(String text)���������ı��İ�ť
					JButton(String text, Icon icon)���������ı���ͼ��İ�ť
			
			6. JCheckBox����ѡ��ť���
				���췽����
					JCheckBox(String text)����ָ�����ı���������ʼ��ѡ�С��ĸ�ѡ��
					JCheckBox(String text, boolean selected)����ָ���ı�����һ����ѡ�򣬲�ָ���Ƿ��ʼѡ�иø�ѡ��
			
			7. JRadioButton����ѡ��ť���
				���췽����
					JRadioButton(String text)����ָ�����ı���������ѡ�С��ĵ�ѡ��ť
					JRadioButton(String text, boolean selected)������ָ�����ı���ѡ��״̬������ѡ��ť
					
			��ѡ��ť�� - ButtonGroup
				���췽����
					ButtonGroup()�������������
					
				��Ա������
					void add(AbstractButton b)������ť��ӵ����С�
			
			8. JComboBox�������б��
				���췽����
					JComboBox()����������Ĭ������ģ�͵� JComboBox��
					JComboBox(Object[] items)����������ָ�������е�Ԫ�ص� JComboBox��
					
				��Ա������
					void addItem(Object anObject) Ϊ���б�����
					Object getItemAt(int index) ����ָ�����������б��
					Object getSelectedItem() ���ص�ǰ��ѡ� 
					int getSelectedIndex()�����ص�ǰѡ���������λ�� 
					
		�˵������
			9. JMenuBar���˵���
			10. JMenu���˵�
			11. JMnuItem���Ӳ˵�
			12. ��ݼ���Java�ṩ�����ַ�ʽ�����ÿ�ݼ���setMnemonic��setAccelerator��
				Mnemonic�����ڲ˵��п��ٵ�����
					�˵�JMenu����ݷ�ʽֻ���õ�����ĸ(A-Z)��
						�˵�.setMnemonic(KeyEvent,VK_A); // A�ɻ��������Ĵ�д��ĸ��
					�˵���JMnuItem�����˿�������Ϊ������ĸ(A-Z)�⣬����������ΪALT/CTRLl+��ĸ����
						�˵���.setMnemonic(KeyEvent.VK_A); // A�ɻ����������õĴ�д��ĸ��
						JMenuItem m1 = new JMenu(��name��, KeyEvent.VK_A); // A�ɻ����������õĴ�д��ĸ��
						
				Accelerator����ȫ�ֿ�ݼ���
						
				eg��
					JMenuBar menuBar = new JMenuBar();
					JMenu fileMenu = new JMenu("File");
					JMenuItem newItem = new JMenuItem("New");
					menuBar.add(fileMenu);
					fileMenu.add(newItem);

				�����ϣ���û�����Alt+F����File�˵���
					fileMenu.setMnemonic(KeyEvent.VK_F);
					newItem.setMnemonic(KeyEvent.VK_N);
					
				�����ϣ���û�����Ctrl+N������һ�����ļ���
					newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					
				�����Ҫ��JMenuBar��ӵ����JFrame�У�
					frame.setJMenuBar(menuBar);
					
		���������
			13. JTable��������
				���췽����
					JTable(Object[][] rowData, Object[] columnNames) ����һ�� JTable ����ʾ��ά���� rowData �е�ֵ����������Ϊ columnNames��
				��Ա������
					int getSelectedColumn() ���ص�һ��ѡ���е����������û��ѡ�����У��򷵻� -1��
					Object getValueAt(int row, int column) ���� row �� column λ�õĵ�Ԫ��ֵ�� 
		
	�����ࣺ
		1. Color
		2. Font
		3. Dimension
		
3. �¼�������ƣ�
	�¼���Ӧ��Ҫ�أ�
		�¼�Դ
		�¼���
			ActionEvent�¼������
			WindowEvent�¼����������
			KeyEvent�¼������̲���
			MouseEvent�¼���������
		�¼�������
		
	ʹ�ò��裺
		1. �����¼�Դ���
		2. �Զ����࣬ʵ��XXXListner�ӿڣ���д����
		3. �����¼������������Զ��������
		4. �����¼�Դ��������addXXXListener()�������ע�����
		
4. �¼���
	ActionEvent�������¼�����ť���£���
	AdjustmentEvent�������¼������ڹ���������ֵ����
	ItemEvent����Ŀ�¼����޸������б��е�ѡ���
	TextEvent���ı��¼����ı�����ı䣩��
	
	MouseEvent�������¼���
		MOUSE_PRESSED�� ����갴��ʱ�������¼���
		MOUSE_RELEASED��������ͷ�ʱ�������¼���
		MOUSE_CLICKED�� ��������ʱ�������¼���
		MOUSE_ENTERED�� ��������ָ������ʱ�������¼���
		MOUSE_EXITED:   ������˳�ָ������ʱ�������¼���
		
	MouseMotionEvent�������¼���
		MOUSE_MOVED:    ������λ�÷����ı�ʱ�������¼���
		MOUSE_DRAGGED:  ����갴����λ�÷����ı�ʱ�������¼���
		
	KeyEvent�¼�������
		KEY_PRESSED��   �����¼�����ĳ����ʱ������
		KEY_RELEASED��  ���ͷż����а��µļ�ʱ������
		KEY_TYPED��     ȷ�����µ����Ǹ���ֵ��ͨ����һ���ַ�����Ӧpressed�¼���