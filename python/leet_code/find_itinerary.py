"""
https://leetcode.com/problems/reconstruct-itinerary/submissions/

"""


from collections import defaultdict

def find_itinerary(tickets):
  n = len(tickets)+1
        
  # Create an adjacency list with key as source and value as list of destinations
  al = defaultdict(list)

  # Count of tickets for each source destination combination
  journey_counts = defaultdict(int) 
  for ticket in tickets:
    al[ticket[0]].append(ticket[1])
    journey_counts[(ticket[0], ticket[1])] += 1
            
  # Sort destinations for each source to ensure lexicographical order
  for ticket in tickets:
    al[ticket[0]].sort()
        
  # Start port is always JFK
  itinerary = ["JFK"]
  used = defaultdict(int)
  determine_itinerary(al, used, journey_counts, itinerary, n)
      
  return itinerary

def determine_itinerary(al, used, journey_counts, itinerary, n):
  if len(itinerary) == n:
    return
 
  source = itinerary[-1]

  for destination in al[source]:
    flight = (source, destination)

    # If flight has already been taken, ignore
    if flight in used and used[flight] >= journey_counts[flight]:
      continue

    # Tentatively add the flight in itinerary
    itinerary.append(destination)
    used[flight] += 1

    determine_itinerary(al, used, journey_counts, itinerary, n)
    if len(itinerary) < n:
      # This ticket cannot be used. Continue looking for other options
      used[flight] -= 1
      itinerary.pop()
    else:
      return

def test():
  assert find_itinerary([["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]) == ["JFK", "NRT", "JFK", "KUL"]
  assert find_itinerary([["EZE","TIA"],["EZE","HBA"],["AXA","TIA"],["JFK","AXA"],["ANU","JFK"],["ADL","ANU"],["TIA","AUA"],["ANU","AUA"],["ADL","EZE"],["ADL","EZE"],["EZE","ADL"],["AXA","EZE"],["AUA","AXA"],["JFK","AXA"],["AXA","AUA"],["AUA","ADL"],["ANU","EZE"],["TIA","ADL"],["EZE","ANU"],["AUA","ANU"]]) == ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]

test()
