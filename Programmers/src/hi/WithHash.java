package hi;

import java.util.HashMap;

public class WithHash {
	/**
	 * 문제 설명 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. 마라톤에
	 * 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한
	 * 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. completion의 길이는 participant의
	 * 길이보다 1 작습니다. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 참가자 중에는 동명이인이 있을 수
	 * 있습니다.
	 *
	 */
	public String marathonSolution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (String a : participant) { // String a 에 participant 가 갖고 있는 것들을 하나 씩 대입해서 participant 모두를 a 에 대입한 후에 끝낸다.
										// ****
			map.put(a, map.getOrDefault(a, 0) + 1); // HashMap.getOrDefault(A, B) => HashMap.get(A) 해서 있으면 그 값 가져 오고,
													// 없으면 B(default 값)를 반환 한다. *****
		}
		for (String a : completion) {
			map.put(a, map.get(a) - 1);

		}
		for (String a : map.keySet()) {
			if (map.get(a) != 0) {
				answer = a;
			}
		}
		return answer;
	}

	/**
	 * 문제 설명 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다. 전화번호가 다음과 같을 경우,
	 * 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의
	 * 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한 사항 phone_book의 길이는 1 이상 1,000,000 이하입니다. 각 전화번호의 길이는 1 이상 20 이하입니다. 입출력 예제
	 * [119, 97674223, 1195524421] false 
	 * [123,456,789] true
	 * [12,123,1235,567,88] false
	 */
	public boolean phonebookSolution(String[] phone_book) {
		boolean answer = true;
		return answer;
	}
}
