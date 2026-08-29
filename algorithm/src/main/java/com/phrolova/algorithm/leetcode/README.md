# LeetCode 刷题记录

按题号组织，每题一个子包，三件套：`Problem.md`（题目描述）、`Solution.md`（题解）、Java 类（代码）。

## 命名约定

| 项 | 规则 | 示例 |
| --- | --- | --- |
| 子包名 | `p` + 四位题号 + `_` + slug（小写+下划线） | `p0001_two_sum` |
| 包声明 | `com.phrolova.algorithm.leetcode.<子包名>` | `...leetcode.p0001_two_sum` |
| 题目描述 | 固定为 `Problem.md` | — |
| 题解 | 固定为 `Solution.md` | — |
| 代码类 | PascalCase，与题名对应 | `TwoSum.java` |

题型、难度写在 `Problem.md` 头部元信息，不另建题型目录。

公共类型见 [`common/`](common/)（`ListNode`、`TreeNode`、`GuessGame`）。

## 新增一题

1. 复制已有题目目录为 `p0xxx_slug`
2. 修改包名与 Java 类名
3. 填写 `Problem.md`、`Solution.md` 与代码
4. 在下方索引表追加一行

## 索引

| 题号 | 题名 | 目录 |
| --- | --- | --- |
| 1 | Two Sum | [p0001_two_sum](p0001_two_sum/) |
| 11 | Container With Most Water | [p0011_container_with_most_water](p0011_container_with_most_water/) |
| 17 | Letter Combinations of a Phone Number | [p0017_letter_combinations_of_a_phone_number](p0017_letter_combinations_of_a_phone_number/) |
| 62 | Unique Paths | [p0062_unique_paths](p0062_unique_paths/) |
| 72 | Edit Distance | [p0072_edit_distance](p0072_edit_distance/) |
| 104 | Maximum Depth of Binary Tree | [p0104_maximum_depth_of_binary_tree](p0104_maximum_depth_of_binary_tree/) |
| 136 | Single Number | [p0136_single_number](p0136_single_number/) |
| 151 | Reverse Words in a String | [p0151_reverse_words_in_a_string](p0151_reverse_words_in_a_string/) |
| 162 | Find Peak Element | [p0162_find_peak_element](p0162_find_peak_element/) |
| 198 | House Robber | [p0198_house_robber](p0198_house_robber/) |
| 199 | Binary Tree Right Side View | [p0199_binary_tree_right_side_view](p0199_binary_tree_right_side_view/) |
| 206 | Reverse Linked List | [p0206_reverse_linked_list](p0206_reverse_linked_list/) |
| 208 | Implement Trie (Prefix Tree) | [p0208_implement_trie_prefix_tree](p0208_implement_trie_prefix_tree/) |
| 215 | Kth Largest Element in an Array | [p0215_kth_largest_element_in_an_array](p0215_kth_largest_element_in_an_array/) |
| 216 | Combination Sum III | [p0216_combination_sum_iii](p0216_combination_sum_iii/) |
| 236 | Lowest Common Ancestor of a Binary Tree | [p0236_lowest_common_ancestor_of_a_binary_tree](p0236_lowest_common_ancestor_of_a_binary_tree/) |
| 238 | Product of Array Except Self | [p0238_product_of_array_except_self](p0238_product_of_array_except_self/) |
| 283 | Move Zeroes | [p0283_move_zeroes](p0283_move_zeroes/) |
| 328 | Odd Even Linked List | [p0328_odd_even_linked_list](p0328_odd_even_linked_list/) |
| 334 | Increasing Triplet Subsequence | [p0334_increasing_triplet_subsequence](p0334_increasing_triplet_subsequence/) |
| 338 | Counting Bits | [p0338_counting_bits](p0338_counting_bits/) |
| 345 | Reverse Vowels of a String | [p0345_reverse_vowels_of_a_string](p0345_reverse_vowels_of_a_string/) |
| 374 | Guess Number Higher or Lower | [p0374_guess_number_higher_or_lower](p0374_guess_number_higher_or_lower/) |
| 392 | Is Subsequence | [p0392_is_subsequence](p0392_is_subsequence/) |
| 394 | Decode String | [p0394_decode_string](p0394_decode_string/) |
| 399 | Evaluate Division | [p0399_evaluate_division](p0399_evaluate_division/) |
| 435 | Non-overlapping Intervals | [p0435_non_overlapping_intervals](p0435_non_overlapping_intervals/) |
| 437 | Path Sum III | [p0437_path_sum_iii](p0437_path_sum_iii/) |
| 443 | String Compression | [p0443_string_compression](p0443_string_compression/) |
| 450 | Delete Node in a BST | [p0450_delete_node_in_a_bst](p0450_delete_node_in_a_bst/) |
| 452 | Minimum Number of Arrows to Burst Balloons | [p0452_minimum_number_of_arrows_to_burst_balloons](p0452_minimum_number_of_arrows_to_burst_balloons/) |
| 547 | Number of Provinces | [p0547_number_of_provinces](p0547_number_of_provinces/) |
| 605 | Can Place Flowers | [p0605_can_place_flowers](p0605_can_place_flowers/) |
| 643 | Maximum Average Subarray I | [p0643_maximum_average_subarray_i](p0643_maximum_average_subarray_i/) |
| 649 | Dota2 Senate | [p0649_dota2_senate](p0649_dota2_senate/) |
| 700 | Search in a Binary Search Tree | [p0700_search_in_a_binary_search_tree](p0700_search_in_a_binary_search_tree/) |
| 714 | Best Time to Buy and Sell Stock with Transaction Fee | [p0714_best_time_to_buy_and_sell_stock_with_transaction_fee](p0714_best_time_to_buy_and_sell_stock_with_transaction_fee/) |
| 724 | Find Pivot Index | [p0724_find_pivot_index](p0724_find_pivot_index/) |
| 735 | Asteroid Collision | [p0735_asteroid_collision](p0735_asteroid_collision/) |
| 739 | Daily Temperatures | [p0739_daily_temperatures](p0739_daily_temperatures/) |
| 746 | Min Cost Climbing Stairs | [p0746_min_cost_climbing_stairs](p0746_min_cost_climbing_stairs/) |
| 790 | Domino and Tromino Tiling | [p0790_domino_and_tromino_tiling](p0790_domino_and_tromino_tiling/) |
| 841 | Keys and Rooms | [p0841_keys_and_rooms](p0841_keys_and_rooms/) |
| 872 | Leaf-Similar Trees | [p0872_leaf_similar_trees](p0872_leaf_similar_trees/) |
| 875 | Koko Eating Bananas | [p0875_koko_eating_bananas](p0875_koko_eating_bananas/) |
| 901 | Online Stock Span | [p0901_online_stock_span](p0901_online_stock_span/) |
| 933 | Number of Recent Calls | [p0933_number_of_recent_calls](p0933_number_of_recent_calls/) |
| 994 | Rotting Oranges | [p0994_rotting_oranges](p0994_rotting_oranges/) |
| 1004 | Max Consecutive Ones III | [p1004_max_consecutive_ones_iii](p1004_max_consecutive_ones_iii/) |
| 1071 | Greatest Common Divisor of Strings | [p1071_greatest_common_divisor_of_strings](p1071_greatest_common_divisor_of_strings/) |
| 1137 | N-th Tribonacci Number | [p1137_n_th_tribonacci_number](p1137_n_th_tribonacci_number/) |
| 1143 | Longest Common Subsequence | [p1143_longest_common_subsequence](p1143_longest_common_subsequence/) |
| 1161 | Maximum Level Sum of a Binary Tree | [p1161_maximum_level_sum_of_a_binary_tree](p1161_maximum_level_sum_of_a_binary_tree/) |
| 1207 | Unique Number of Occurrences | [p1207_unique_number_of_occurrences](p1207_unique_number_of_occurrences/) |
| 1268 | Search Suggestions System | [p1268_search_suggestions_system](p1268_search_suggestions_system/) |
| 1318 | Minimum Flips to Make a OR b Equal to c | [p1318_minimum_flips_to_make_a_or_b_equal_to_c](p1318_minimum_flips_to_make_a_or_b_equal_to_c/) |
| 1372 | Longest ZigZag Path in a Binary Tree | [p1372_longest_zigzag_path_in_a_binary_tree](p1372_longest_zigzag_path_in_a_binary_tree/) |
| 1431 | Kids With the Greatest Number of Candies | [p1431_kids_with_the_greatest_number_of_candies](p1431_kids_with_the_greatest_number_of_candies/) |
| 1448 | Count Good Nodes in Binary Tree | [p1448_count_good_nodes_in_binary_tree](p1448_count_good_nodes_in_binary_tree/) |
| 1456 | Maximum Number of Vowels in a Substring of Given Length | [p1456_maximum_number_of_vowels_in_a_substring_of_given_length](p1456_maximum_number_of_vowels_in_a_substring_of_given_length/) |
| 1466 | Reorder Routes to Make All Paths Lead to the City Zero | [p1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero](p1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero/) |
| 1493 | Longest Subarray of 1's After Deleting One Element | [p1493_longest_subarray_of_1s_after_deleting_one_element](p1493_longest_subarray_of_1s_after_deleting_one_element/) |
| 1657 | Determine if Two Strings Are Close | [p1657_determine_if_two_strings_are_close](p1657_determine_if_two_strings_are_close/) |
| 1679 | Max Number of K-Sum Pairs | [p1679_max_number_of_k_sum_pairs](p1679_max_number_of_k_sum_pairs/) |
| 1732 | Find the Highest Altitude | [p1732_find_the_highest_altitude](p1732_find_the_highest_altitude/) |
| 1768 | Merge Strings Alternately | [p1768_merge_strings_alternately](p1768_merge_strings_alternately/) |
| 1926 | Nearest Exit from Entrance in Maze | [p1926_nearest_exit_from_entrance_in_maze](p1926_nearest_exit_from_entrance_in_maze/) |
| 2095 | Delete the Middle Node of a Linked List | [p2095_delete_the_middle_node_of_a_linked_list](p2095_delete_the_middle_node_of_a_linked_list/) |
| 2130 | Maximum Twin Sum of a Linked List | [p2130_maximum_twin_sum_of_a_linked_list](p2130_maximum_twin_sum_of_a_linked_list/) |
| 2215 | Find the Difference of Two Arrays | [p2215_find_the_difference_of_two_arrays](p2215_find_the_difference_of_two_arrays/) |
| 2300 | Successful Pairs of Spells and Potions | [p2300_successful_pairs_of_spells_and_potions](p2300_successful_pairs_of_spells_and_potions/) |
| 2336 | Smallest Number in Infinite Set | [p2336_smallest_number_in_infinite_set](p2336_smallest_number_in_infinite_set/) |
| 2352 | Equal Row and Column Pairs | [p2352_equal_row_and_column_pairs](p2352_equal_row_and_column_pairs/) |
| 2390 | Removing Stars From a String | [p2390_removing_stars_from_a_string](p2390_removing_stars_from_a_string/) |
| 2462 | Total Cost to Hire K Workers | [p2462_total_cost_to_hire_k_workers](p2462_total_cost_to_hire_k_workers/) |
| 2542 | Maximum Subsequence Score | [p2542_maximum_subsequence_score](p2542_maximum_subsequence_score/) |

## LeetCode 75

学习计划：[leetcode-75](https://leetcode.cn/studyplan/leetcode-75/)

### 数组 / 字符串

- [1768. Merge Strings Alternately](p1768_merge_strings_alternately/)
- [1071. Greatest Common Divisor of Strings](p1071_greatest_common_divisor_of_strings/)
- [1431. Kids With the Greatest Number of Candies](p1431_kids_with_the_greatest_number_of_candies/)
- [605. Can Place Flowers](p0605_can_place_flowers/)
- [345. Reverse Vowels of a String](p0345_reverse_vowels_of_a_string/)
- [151. Reverse Words in a String](p0151_reverse_words_in_a_string/)
- [238. Product of Array Except Self](p0238_product_of_array_except_self/)
- [334. Increasing Triplet Subsequence](p0334_increasing_triplet_subsequence/)
- [443. String Compression](p0443_string_compression/)

### 双指针

- [283. Move Zeroes](p0283_move_zeroes/)
- [392. Is Subsequence](p0392_is_subsequence/)
- [11. Container With Most Water](p0011_container_with_most_water/)
- [1679. Max Number of K-Sum Pairs](p1679_max_number_of_k_sum_pairs/)

### 滑动窗口

- [643. Maximum Average Subarray I](p0643_maximum_average_subarray_i/)
- [1456. Maximum Number of Vowels in a Substring of Given Length](p1456_maximum_number_of_vowels_in_a_substring_of_given_length/)
- [1004. Max Consecutive Ones III](p1004_max_consecutive_ones_iii/)
- [1493. Longest Subarray of 1's After Deleting One Element](p1493_longest_subarray_of_1s_after_deleting_one_element/)

### 前缀和

- [1732. Find the Highest Altitude](p1732_find_the_highest_altitude/)
- [724. Find Pivot Index](p0724_find_pivot_index/)

### 哈希表 / 哈希集合

- [2215. Find the Difference of Two Arrays](p2215_find_the_difference_of_two_arrays/)
- [1207. Unique Number of Occurrences](p1207_unique_number_of_occurrences/)
- [1657. Determine if Two Strings Are Close](p1657_determine_if_two_strings_are_close/)
- [2352. Equal Row and Column Pairs](p2352_equal_row_and_column_pairs/)

### 栈

- [2390. Removing Stars From a String](p2390_removing_stars_from_a_string/)
- [735. Asteroid Collision](p0735_asteroid_collision/)
- [394. Decode String](p0394_decode_string/)

### 队列

- [933. Number of Recent Calls](p0933_number_of_recent_calls/)
- [649. Dota2 Senate](p0649_dota2_senate/)

### 链表

- [2095. Delete the Middle Node of a Linked List](p2095_delete_the_middle_node_of_a_linked_list/)
- [328. Odd Even Linked List](p0328_odd_even_linked_list/)
- [206. Reverse Linked List](p0206_reverse_linked_list/)
- [2130. Maximum Twin Sum of a Linked List](p2130_maximum_twin_sum_of_a_linked_list/)

### 二叉树 - 深度优先搜索

- [104. Maximum Depth of Binary Tree](p0104_maximum_depth_of_binary_tree/)
- [872. Leaf-Similar Trees](p0872_leaf_similar_trees/)
- [1448. Count Good Nodes in Binary Tree](p1448_count_good_nodes_in_binary_tree/)
- [437. Path Sum III](p0437_path_sum_iii/)
- [1372. Longest ZigZag Path in a Binary Tree](p1372_longest_zigzag_path_in_a_binary_tree/)
- [236. Lowest Common Ancestor of a Binary Tree](p0236_lowest_common_ancestor_of_a_binary_tree/)

### 二叉树 - 广度优先搜索

- [199. Binary Tree Right Side View](p0199_binary_tree_right_side_view/)
- [1161. Maximum Level Sum of a Binary Tree](p1161_maximum_level_sum_of_a_binary_tree/)

### 二叉搜索树

- [700. Search in a Binary Search Tree](p0700_search_in_a_binary_search_tree/)
- [450. Delete Node in a BST](p0450_delete_node_in_a_bst/)

### 图 - 深度优先搜索

- [841. Keys and Rooms](p0841_keys_and_rooms/)
- [547. Number of Provinces](p0547_number_of_provinces/)
- [1466. Reorder Routes to Make All Paths Lead to the City Zero](p1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero/)
- [399. Evaluate Division](p0399_evaluate_division/)

### 图 - 广度优先搜索

- [1926. Nearest Exit from Entrance in Maze](p1926_nearest_exit_from_entrance_in_maze/)
- [994. Rotting Oranges](p0994_rotting_oranges/)

### 堆 / 优先队列

- [215. Kth Largest Element in an Array](p0215_kth_largest_element_in_an_array/)
- [2336. Smallest Number in Infinite Set](p2336_smallest_number_in_infinite_set/)
- [2542. Maximum Subsequence Score](p2542_maximum_subsequence_score/)
- [2462. Total Cost to Hire K Workers](p2462_total_cost_to_hire_k_workers/)

### 二分查找

- [374. Guess Number Higher or Lower](p0374_guess_number_higher_or_lower/)
- [2300. Successful Pairs of Spells and Potions](p2300_successful_pairs_of_spells_and_potions/)
- [162. Find Peak Element](p0162_find_peak_element/)
- [875. Koko Eating Bananas](p0875_koko_eating_bananas/)

### 回溯

- [17. Letter Combinations of a Phone Number](p0017_letter_combinations_of_a_phone_number/)
- [216. Combination Sum III](p0216_combination_sum_iii/)

### 动态规划 - 一维

- [1137. N-th Tribonacci Number](p1137_n_th_tribonacci_number/)
- [746. Min Cost Climbing Stairs](p0746_min_cost_climbing_stairs/)
- [198. House Robber](p0198_house_robber/)
- [790. Domino and Tromino Tiling](p0790_domino_and_tromino_tiling/)

### 动态规划 - 多维

- [62. Unique Paths](p0062_unique_paths/)
- [1143. Longest Common Subsequence](p1143_longest_common_subsequence/)
- [714. Best Time to Buy and Sell Stock with Transaction Fee](p0714_best_time_to_buy_and_sell_stock_with_transaction_fee/)
- [72. Edit Distance](p0072_edit_distance/)

### 位运算

- [338. Counting Bits](p0338_counting_bits/)
- [136. Single Number](p0136_single_number/)
- [1318. Minimum Flips to Make a OR b Equal to c](p1318_minimum_flips_to_make_a_or_b_equal_to_c/)

### 前缀树

- [208. Implement Trie (Prefix Tree)](p0208_implement_trie_prefix_tree/)
- [1268. Search Suggestions System](p1268_search_suggestions_system/)

### 区间集合

- [435. Non-overlapping Intervals](p0435_non_overlapping_intervals/)
- [452. Minimum Number of Arrows to Burst Balloons](p0452_minimum_number_of_arrows_to_burst_balloons/)

### 单调栈

- [739. Daily Temperatures](p0739_daily_temperatures/)
- [901. Online Stock Span](p0901_online_stock_span/)
