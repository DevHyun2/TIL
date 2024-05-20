package train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) // 입력이 "0 0"일 때 반복문 종료
				break;

			int[][] size = new int[w][h];

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					if (st.hasMoreTokens()) {
						size[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}

		}

	}

}