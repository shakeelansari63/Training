from icrawler.builtin import BingImageCrawler

celebs = ['Desert', 'Jungle', 'Sea', 'Ocean', 'Humans']

numbers = 1000

for celeb in celebs:
    bing_crawler = BingImageCrawler(
        storage={'root_dir': 'img/{}'.format(celeb)})
    bing_crawler.crawl(keyword=celeb, filters=None, offset=0, max_num=numbers)
